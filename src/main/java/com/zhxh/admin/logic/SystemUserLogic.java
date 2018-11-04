package com.zhxh.admin.logic;

import com.zhxh.admin.dao.RoleUserDAO;
import com.zhxh.admin.dao.SystemProgramDAO;
import com.zhxh.admin.dao.SystemRoleDAO;
import com.zhxh.admin.dao.SystemUserDAO;
import com.zhxh.admin.entity.*;
import com.zhxh.core.env.SysEnv;
import com.zhxh.core.utils.StringUtilsExt;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.zhxh.admin.misc.ErrorCode.ERROR_ADMIN_OLD_PASSWORD_ERROR;
import static com.zhxh.core.exception.ErrorCode.ERROR_UNKNOWN_EXCEPTION;
import static com.zhxh.core.exception.ExceptionHelper.throwException;

@Component("systemUserLogic")
public class SystemUserLogic {
    @Resource(name = "systemUserDAO")
    private SystemUserDAO systemUserDAO;
    @Resource(name = "systemRoleDAO")
    private SystemRoleDAO systemRoleDAO;
    @Resource(name="systemRoleLogic")
    private SystemRoleLogic systemRoleLogic;

    @Resource(name = "roleUserDAO")
    private RoleUserDAO roleUserDAO;    
    @Resource(name="systemProgramDAO")
    private SystemProgramDAO systemProgramDAO;
    @Resource(name="authenticateLogic")
    private AuthenticateLogic authenticateLogic;

    public int changePassword(String pwd, String oldPwd) throws Exception {
        SystemUser currentUser = authenticateLogic.getCurrentLogin();
        return this.changePassword(currentUser, pwd, oldPwd);
    }

    public int changePassword(SystemUser user, String pwd, String oldPwd) throws Exception {
        String md5 = StringUtilsExt.getMd5(oldPwd);
        if (!md5.equals(user.getPassword())) {
            throwException(ERROR_ADMIN_OLD_PASSWORD_ERROR);
        }
        user.setPassword(pwd);
        return systemUserDAO.update(user);
    }

    public int changePassword(String userId, String pwd, String oldPwd) throws Exception {
        SystemUser user = systemUserDAO.getById(userId);
        return this.changePassword(user, pwd, oldPwd);
    }

    @Transactional(rollbackFor = Exception.class)
    public int openLoginAccount(SystemUser item) throws Exception {
        //1.新建本身的数据
        //2.授予权限:这一步在权限授予里面完成
        //3.通知用户
        String passwordMd5 = StringUtilsExt.getMd5(item.getPassword());
        item.setPassword(passwordMd5);
        int result = systemUserDAO.insert(item);
        if (result == 1) {
            //TODO:在这里Email通知相关账户
        }
        return result;
    }
    
    public int update(SystemUser item) throws Exception {
        SystemUser dbItem = systemUserDAO.getById(item.getUserId());
        item.setPassword(dbItem.getPassword());
        return systemUserDAO.update(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public int delete(String[] userIdList) throws Exception {
        //注意：正常来说，系统不允许删除账号
        //1.删除相关的权限信息
        //2.删除本身
        //3.通知系统管理员
    	for(String userId:userIdList) {    		
	        roleUserDAO.revokeUserAllRoles(userId);
	        int result = systemUserDAO.deleteById(userId);
	        if(result!=1){
	            throwException(ERROR_UNKNOWN_EXCEPTION);
	        }
    	}
        //
        //TODO:在这里发送通知给管理员
        //
        return userIdList.length;
    }

    public int addRole(String userId, String roleId) throws Exception {
        systemUserDAO.verifyExistsById(userId);
        systemRoleDAO.verifyExistsById(roleId);

        RoleUser roleUser = new RoleUser();
        roleUser.setRoleId(roleId);
        roleUser.setUserId(userId);

        return roleUserDAO.insert(roleUser);
    }

    public int removeRole(String userId, String roleId) throws Exception {
        RoleUser roleUser = roleUserDAO.getByUserIdAndRoleId(userId, roleId);
        if (roleUser != null) {
            roleUserDAO.delete(roleUser);
        }
        return 0;
    }

    public int disableUser(String userId) throws Exception {
        SystemUser dbUser =  this.systemUserDAO.verifyExistsById(userId);
        dbUser.setUserStatus(SystemUser.USER_STATUS_DISABLED);
        return systemUserDAO.update(dbUser);
    }

    public int enableUser(String userId) throws Exception {
        SystemUser dbUser =  this.systemUserDAO.verifyExistsById(userId);
        dbUser.setUserStatus(SystemUser.USER_STATUS_NORMAL);
        return systemUserDAO.update(dbUser);
    }

    public List<SystemRole> getUserRoles(String userId) {
        return roleUserDAO.getUserRoles(userId);
    }

    @Transactional(rollbackFor = Exception.class)
    public int resetPassword(String userId) throws Exception {
        SystemUser dbUser =  this.systemUserDAO.verifyExistsById(userId);
        dbUser.setPassword(StringUtilsExt.getMd5(SystemUser.DEFAULT_PASSWORD));
        int result = systemUserDAO.update(dbUser);
        if (result != 1) {
            throwException(ERROR_UNKNOWN_EXCEPTION);
        }
        //
        // TODO:发送Email通知该用户
        //
        return result;
    }

    public SystemUserDAO getSystemUserDAO() {
        return this.systemUserDAO;
    }
    
    public boolean hasPrivilege(String userId,String programId,String privilegeId) {
    	List<SystemRole> roleList= this.getUserRoles(userId);
    	for(SystemRole role : roleList) {
			if(systemRoleLogic.hasPrivilege(role.getRoleId(),programId,privilegeId)) {
				return true;
			}
		}
    	return false;
    }

    public List<RolePrivilege> getUserAllPrivileges(String userId){
        List<SystemRole> roles = this.getUserRoles(userId);
        List<RolePrivilege> result = new ArrayList<>();
        for(SystemRole role:roles){
            List<RolePrivilege> privileges = systemRoleLogic.getRolePrivileges(role.getRoleId());
            privileges.removeIf(x->result.stream().anyMatch(y->y.getPrivilegeId().equals(x.getPrivilegeId()) && y.getProgramId().equals(x.getProgramId())));
            result.addAll(privileges);
        }

        return result;
    }
    
	public boolean canRun(String userId, String url) {
	    List<SystemRole> roleList= this.getUserRoles(userId);
	    String pureUrl = url.replace(SysEnv.getAppRoot(),"");
		/**
		 * 1.首页：所有人都有权限:  "/mes";"/"
		 * 2.登录页：所有人都有权限:"/login.jsp"
		 * 3.其他页：要根据权限判断
		 */
		if(SysEnv.getAppRoot().equals(pureUrl) || SysEnv.getUrlAppIndex().equals(pureUrl)
                || SysEnv.getAppAbsoluteRootPath().equals(pureUrl) || SysEnv.getUrlLoginPage().equals(pureUrl)) {
			return true;
		}
		SystemProgram program = systemProgramDAO.getSystemProgramByUrl(pureUrl);
		if(program==null) {
			return false;
		}
		for(SystemRole role : roleList) {
			if(systemRoleLogic.hasPrivilege(role.getRoleId(),program.getProgramId(),ProgramPrivilege.PROGRAM_RUN)) {
				return true;
			}
		}
		return false;
	}
}
