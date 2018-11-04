package com.zhxh.admin.logic;

import com.zhxh.admin.dao.*;
import com.zhxh.admin.entity.*;
import com.zhxh.admin.vo.ProgramPrivilegeVO;
import com.zhxh.admin.vo.SystemMenuWithPrivilege;
import com.zhxh.core.data.EntityObject;
import com.zhxh.core.exception.ErrorCode;
import com.zhxh.core.exception.ExceptionHelper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static com.zhxh.admin.misc.ErrorCode.ERROR_ADMIN_ROLE_CONTAINS_USERS;
import static com.zhxh.core.exception.ExceptionHelper.throwException;

@Component("systemRoleLogic")
public class SystemRoleLogic {
    @Resource(name = "roleUserDAO")
    private RoleUserDAO roleUserDAO;
    @Resource(name = "rolePrivilegeDAO")
    private RolePrivilegeDAO rolePrivilegeDAO;
    @Resource(name = "systemProgramDAO")
    private SystemProgramDAO systemProgramDAO;
    @Resource(name = "programPrivilegeDAO")
    private ProgramPrivilegeDAO programPrivilegeDAO;

    @Resource(name="systemRoleDAO")
    private SystemRoleDAO systemRoleDAO;

    public boolean hasPrivilege(String roleId,String programId,String privilegeId) {
    	RolePrivilege rolePrivilege = rolePrivilegeDAO.getRolePrivilege(roleId, programId, privilegeId);
    	return rolePrivilege!=null;    		
    }    

    public List<SystemUser> getRoleUsers(String roleId) {
        return roleUserDAO.getRoleUsers(roleId);
    }

    public List<RolePrivilege> getRolePrivileges(String roleId){
        return rolePrivilegeDAO.getRoleAllPrivileges(roleId);
    }

    public List<SystemRole> getAll(){
        return systemRoleDAO.getAll();
    }

    public SystemRole insert(SystemRole role) throws Exception {
        systemRoleDAO.insert(role);
        return role;
    }

    public SystemRole update(SystemRole role) throws Exception {
        systemRoleDAO.update(role);
        return role;
    }

    @Transactional(rollbackFor = Exception.class)
    public int delete(String[] roleIdList) throws Exception {
        //注意：正常来说，系统不允许删除账号
        //1.删除相关的权限信息
        //2.删除本身
        //3.通知系统管理员
        for(String roleId:roleIdList) {
            if(!this.getRoleUsers(roleId).isEmpty()){
                throwException(ERROR_ADMIN_ROLE_CONTAINS_USERS,roleId);
            }

            int result = systemRoleDAO.deleteById(roleId);
            if(result!=1){
                throwException(ErrorCode.ERROR_UNKNOWN_EXCEPTION,"");
            }
        }
        return roleIdList.length;
    }

    @Transactional(rollbackFor = Exception.class)
    public void updatePrivileges(String roleId, ProgramPrivilegeVO[] currentList) throws Exception {
        //1.获取原权限  oldList
        //2.收回已取消的权限    oldList - currentList
        //3.授予新的权限   currentList - oldList

        List<RolePrivilege> oldList = this.getRolePrivileges(roleId);
        List<RolePrivilege> revokeList = new ArrayList<>();
        for(RolePrivilege old:oldList){
            boolean founded = false;
            for(ProgramPrivilegeVO current: currentList){
                if(!old.getProgramId().equals(current.getProgramId())){
                    continue;
                }
                if(old.getPrivilegeId().equals(current.getPrivilegeId())){
                    founded=true;
                    break;
                }
            }
            if(!founded){
                revokeList.add(old);
            }
        }
        List<RolePrivilege> grantList = new ArrayList<>();
        for(ProgramPrivilegeVO current:currentList){
            boolean founded = false;
            for(RolePrivilege old:oldList){
                if(!current.getProgramId().equals(old.getProgramId())){
                    continue;
                }
                if(current.getPrivilegeId().equals(old.getPrivilegeId())){
                    founded=true;
                    break;
                }
            }
            if(!founded){
                RolePrivilege rolePrivilege = new RolePrivilege(roleId,current);
                grantList.add(rolePrivilege);
            }
        }

        for(RolePrivilege old:revokeList){
            this.revokePrivilege(roleId,old);
        }

        for(RolePrivilege grant:grantList){
            this.grantPrivilege(roleId,grant);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public synchronized void grantPrivilege(String roleId, RolePrivilege privilege) throws Exception {
        RolePrivilege rolePrivilege = rolePrivilegeDAO.getPrivilege(roleId, privilege.getProgramId(),privilege.getPrivilegeId());
        if (rolePrivilege == null) {
            //1.对本身授权
            if (rolePrivilegeDAO.insert(privilege) != 1) {
                throw new Exception("授权失败！");
            }
            //2.本身如果没有"运行"权限，对本身授予"运行"权限
            ProgramPrivilege programRunPrivilege = programPrivilegeDAO.getProgramRunPrivilege(privilege.getProgramId());
            if(null!=programRunPrivilege) {
            	rolePrivilege = rolePrivilegeDAO.getPrivilege(roleId, programRunPrivilege.getProgramId(),programRunPrivilege.getPrivilegeId());
            	if (rolePrivilege == null) {
            		rolePrivilege = new RolePrivilege(roleId,programRunPrivilege);
            		
            		if (rolePrivilegeDAO.insert(rolePrivilege) != 1) {
            			throw new Exception("授予运行权限失败!");
            		}
            	}
            	//3.如果上级还没有运行权限，对上级菜单授予"运行"权限
            	this.grantParentRunPrivilege(roleId,privilege);
            }
        }
    }

    private void grantParentRunPrivilege(String roleId, RolePrivilege privilege) throws Exception {
        SystemProgram parent = systemProgramDAO.getParent(privilege.getProgramId());
        if(parent==null){
            return;
        }

        ProgramPrivilege parentRunPrivilege = programPrivilegeDAO.getProgramRunPrivilege(parent.getProgramId());
        if(null!=parentRunPrivilege) {
        	RolePrivilege  rolePrivilege = rolePrivilegeDAO.getPrivilege(roleId, parentRunPrivilege.getProgramId(),parentRunPrivilege.getPrivilegeId());
        	if (rolePrivilege == null) {
        		rolePrivilege = new RolePrivilege(roleId,parentRunPrivilege);
        		if (rolePrivilegeDAO.insert(rolePrivilege) != 1) {
        			throw new Exception("对上级菜单授予运行权限失败!");
        		}
        		
        		grantParentRunPrivilege(roleId,rolePrivilege);
        	}
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public synchronized void revokePrivilege(String roleId, RolePrivilege privilegeVO) throws Exception {
        RolePrivilege rolePrivilege = rolePrivilegeDAO.getPrivilege(roleId, privilegeVO.getProgramId(),privilegeVO.getPrivilegeId());
        if (rolePrivilege == null) {
            return;
        }
        String programId = rolePrivilege.getProgramId();
        //1.撤销自身的授权
        if (rolePrivilegeDAO.delete(rolePrivilege) != 1) {
            throw new Exception("撤销权限失败！");
        }
        //2.如果是程序的运行权限，则要撤销所有的其他权限
        if(ProgramPrivilege.PROGRAM_RUN.equals(rolePrivilege.getPrivilegeId())){
            rolePrivilegeDAO.removeProgramAllPrivilege(roleId,programId);
        }
        //3.如果是菜单文件夹，还要撤销所有的下级程序的所有权限
        SystemProgram program = systemProgramDAO.getById(programId);
        if(null!=program) {
        	if (program.isFolder()) {
                try {
                    List<SystemProgram> allPrograms = systemProgramDAO.getAll();
                    this.revokeChildrenPrivilege(allPrograms, roleId, program);
                } catch (Exception e) {
                    throw new Exception("撤销下级权限失败:" + ExceptionHelper.exceptionStackTrace(e));
                }
            }
        }
        
    }

    public List<SystemMenuWithPrivilege> getSystemMenuWithPrivilege() {
        List<SystemProgram> allPrograms = systemProgramDAO.getAll();
        List<SystemMenuWithPrivilege> result = new ArrayList<>();
        SystemProgram[] topPrograms = allPrograms.stream()
                .filter(x -> x.isTopMenu())
                .sorted(Comparator.comparing(SystemProgram::getShowOrder))
                .toArray(SystemProgram[]::new);
        List<ProgramPrivilege> allPrivileges = programPrivilegeDAO.getAll();

        for (SystemProgram top : topPrograms) {
            SystemMenuWithPrivilege menu = menuWithPrivilegeFromProgram(top, allPrivileges);
            result.add(menu);
            this.buildMenuWithPrivilege(allPrograms, allPrivileges, top, menu);
        }

        return result;
    }

    private void buildMenuWithPrivilege(List<SystemProgram> programList, List<ProgramPrivilege> privilegeList,  SystemProgram program, SystemMenuWithPrivilege menu) {
        SystemProgram[] parentPrograms = programList.stream()
                .filter(x -> x.getParent().equals(program.getProgramId())
                        && !x.getProgramId().equals(menu.getProgramId())
                ).sorted(Comparator.comparing(SystemProgram::getShowOrder))
                .toArray(SystemProgram[]::new);

        SystemMenuWithPrivilege[] children = new SystemMenuWithPrivilege[parentPrograms.length];
        menu.setChildren(children);
        for (int i = 0; i < parentPrograms.length; i++) {
            SystemProgram son = parentPrograms[i];
            SystemMenuWithPrivilege sonMenu = menuWithPrivilegeFromProgram(son, privilegeList);
            children[i] = sonMenu;

            if(son.isFolder()) {
                this.buildMenuWithPrivilege(programList, privilegeList, son, sonMenu);
            }
        }
    }

    private SystemMenuWithPrivilege menuWithPrivilegeFromProgram(SystemProgram top, List<ProgramPrivilege> privilegeList) {
        SystemMenuWithPrivilege menu = new SystemMenuWithPrivilege();
        menu.setProgramId(top.getProgramId());
        menu.setProgramName(top.getProgramName());
        menu.setUrl(top.getUrl());
        menu.setGlyph(top.getGlyph());
        if(menu.isFolder()){
            menu.setDataType("app.model.admin.SystemMenuTreeModel");
            menu.setExpanded(true);
        }else {
            //
            //1.只有是实际运行的程序而不是一个文件夹，才需要显示权限。
            //2.如果有其他的权限，"运行"权限是默认具备的,不需要显示。
            //
            ProgramPrivilege[] privileges = privilegeList.stream()
                    .filter(x -> !x.isRunPrivilege() && x.getProgramId().equals(top.getProgramId()))
                    .toArray(ProgramPrivilege[]::new);
            ProgramPrivilegeVO[] voList = new ProgramPrivilegeVO[privileges.length];
            for(int i=0;i<privileges.length;i++){
                ProgramPrivilegeVO vo = new ProgramPrivilegeVO();
                vo.setDataType("app.model.admin.ProgramPrivilegeModel");
                EntityObject.copy(privileges[i],vo);
                voList[i] = vo;
            }
            menu.setChildren(voList);
        }

        return menu;
    }


    public List<SystemMenuWithPrivilege> getRoleMenuWithPrivilege(String roleId) {
        List<SystemProgram> allPrograms = systemProgramDAO.getAll();
        List<SystemMenuWithPrivilege> result = new ArrayList<>();
        SystemProgram[] topPrograms = allPrograms.stream()
                .filter(x -> x.isTopMenu())
                .sorted(Comparator.comparing(SystemProgram::getShowOrder))
                .toArray(SystemProgram[]::new);
        List<ProgramPrivilege> allPrivileges = programPrivilegeDAO.getAll();
        List<RolePrivilege> allRolePrivileges = rolePrivilegeDAO.getRoleAllPrivileges(roleId);

        for (SystemProgram top : topPrograms) {
            SystemMenuWithPrivilege menu = menuWithPrivilegeFromProgram(top, allPrivileges, allRolePrivileges);
            result.add(menu);

            this.buildMenuWithPrivilege(allPrograms, allPrivileges, allRolePrivileges, top, menu);
        }

        return result;
    }



    private void revokeChildrenPrivilege(List<SystemProgram> allPrograms, String roleId, SystemProgram program) {
        SystemProgram[] children = allPrograms.stream()
                .filter(x -> x.getParent().equals(program.getProgramId()) && !x.getProgramId().equals(program.getProgramId()))
                .toArray(SystemProgram[]::new);
        for (SystemProgram child : children) {
            revokeChildrenPrivilege(allPrograms, roleId, child);
        }
        rolePrivilegeDAO.deleteRoleSubProgramPrivilege(roleId, program.getProgramId());
    }

    private SystemMenuWithPrivilege menuWithPrivilegeFromProgram(SystemProgram top, List<ProgramPrivilege> privilegeList, List<RolePrivilege> rolePrivilegeList) {
        SystemMenuWithPrivilege menu = new SystemMenuWithPrivilege();
        menu.setProgramId(top.getProgramId());
        menu.setProgramName(top.getProgramName());
        menu.setUrl(top.getUrl());
        menu.setChecked(true);

        if (!menu.isFolder()) {
            //
            //1.只有是实际运行的程序而不是一个文件夹，才需要显示权限。
            //2.如果有其他的权限，"运行"权限是默认具备的,不需要显示。
            //
            ProgramPrivilegeVO[] privileges = privilegeList.stream()
                    .filter(x -> !x.isRunPrivilege() && x.getProgramId().equals(top.getProgramId()))
                    .toArray(ProgramPrivilegeVO[]::new);

            Arrays.stream(privileges).forEach(x -> {
                boolean isChecked = rolePrivilegeList.stream()
                        .anyMatch(y -> y.getPrivilegeId().equals(x.getPrivilegeId()));
                x.setChecked(isChecked);
            });
            menu.setChildren(privileges);
        }

        return menu;
    }

    private void buildMenuWithPrivilege(List<SystemProgram> programList, List<ProgramPrivilege> privilegeList, List<RolePrivilege> rolePrivilegeList, SystemProgram program, SystemMenuWithPrivilege menu) {
        SystemProgram[] parentPrograms = programList.stream()
                .filter(x -> x.getParent().equals(program.getProgramId()))
                .sorted(Comparator.comparing(SystemProgram::getShowOrder))
                .toArray(SystemProgram[]::new);

        SystemMenuWithPrivilege[] children = new SystemMenuWithPrivilege[parentPrograms.length];
        menu.setChildren(children);
        for (int i = 0; i < parentPrograms.length; i++) {
            SystemProgram son = parentPrograms[i];
            SystemMenuWithPrivilege sonMenu = menuWithPrivilegeFromProgram(son, privilegeList, rolePrivilegeList);
            children[i] = sonMenu;

            this.buildMenuWithPrivilege(programList, privilegeList, rolePrivilegeList, son, sonMenu);
        }
    }
}
