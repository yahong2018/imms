package com.zhxh.admin.dao;

import com.zhxh.admin.entity.ProgramPrivilege;
import com.zhxh.admin.entity.RolePrivilege;
import com.zhxh.core.data.BaseDAOWithEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("rolePrivilegeDAO")
public class RolePrivilegeDAO extends BaseDAOWithEntity<RolePrivilege> {
	public RolePrivilege getRolePrivilege(String roleId, String programId, String privilegeId) {
		String where = "role_id=#{roleId} and program_id=#{programId} and privilege_id=#{privilegeId}";
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("roleId", roleId);
		parameters.put("programId", programId);
		parameters.put("privilegeId", privilegeId);
		
		return this.getOne(where,parameters);
	}
	
    public List<RolePrivilege> getRoleAllPrivileges(String roleId) {
        Map parameters = new HashMap();
        parameters.put("roleId", roleId);
        String where = "role_id=#{roleId}";
        Map listMap = new HashMap();
        listMap.put("where", where);

        return this.getList(listMap, parameters);
    }

    public int removeProgramAllPrivilege(String roleId,String programId){
	    String where = " where role_id=#{roleId} and program_id=#{programId}";
	    Map parameters = new HashMap();
	    parameters.put("roleId",roleId);
	    parameters.put("programId",programId);

	    return this.deleteByWhere(where,parameters);
    }

    public int getOtherGrantedPrivilegeCount(RolePrivilege rolePrivilege) {
        Map parameters = new HashMap();
        parameters.put("rolePrivilegeId", rolePrivilege.getRolePrivilegeId());
        parameters.put("programId", rolePrivilege.getProgramId());
        parameters.put("runPrivilegeId", ProgramPrivilege.PROGRAM_RUN);

        return this.getSqlHelper().getSqlSession().selectOne(SQL_GET_OTHER_GRANTED_PRIVILEGE_COUNT, parameters);
    }

    public int getBrotherGrantedPrivilegeCount(int rolePrivilegeId, String parent) {
        Map parameters = new HashMap();
        parameters.put("rolePrivilegeId", rolePrivilegeId);
        parameters.put("parent", parent);

        return this.getSqlHelper().getSqlSession().selectOne(SQL_GET_BROTHER_GRANTED_PRIVILEGE_COUNT, parameters);
    }

    public int deleteRoleSubProgramPrivilege(String roleId, String parent) {
        Map parameters = new HashMap();
        parameters.put("roleId", roleId);
        parameters.put("parent", parent);

        return this.getSqlHelper().getSqlSession().delete(SQL_DELETE_ROLE_SUB_PROGRAM_PRIVILEGE, parameters);
    }

    @Override
    protected int doInsert(RolePrivilege item) {
        return this.getSqlHelper().getSqlSession().insert(SQL_INSERT_ROLE_PRIVILEGE, item);
    }

    public RolePrivilege getPrivilege(String roleId, String programId,String privilegeId) {
        Map parameters = new HashMap();
        parameters.put("roleId", roleId);
        parameters.put("programId", programId);
        parameters.put("privilegeId",privilegeId);

        String where = "role_id=#{roleId} and program_id=#{programId} and privilege_id=#{privilegeId}";
        return this.getOne(where, parameters);
    }
    
    public int removeRolePrivilegeByProgramIdAndPrivilegeId(String programId,String privilegeId){
	    String where = " where program_id=#{programId} and privilege_Id=#{privilegeId}";
	    Map parameters = new HashMap();
	    parameters.put("programId",programId);
	    parameters.put("privilegeId",privilegeId);
	    return this.deleteByWhere(where,parameters);
    }
    
    public int removeRolePrivilegeByProgramId(String programId){
	    String where = " where program_id=#{programId}";
	    Map parameters = new HashMap();
	    parameters.put("programId",programId);
	    return this.deleteByWhere(where,parameters);
    }
       

    protected final static String SQL_INSERT_ROLE_PRIVILEGE = "com.zhxh.admin.dao.INSERT_ROLE_PRIVILEGE";
    protected final static String SQL_GET_OTHER_GRANTED_PRIVILEGE_COUNT = "com.zhxh.admin.dao.GET_OTHER_GRANTED_PRIVILEGE_COUNT";
    protected final static String SQL_GET_BROTHER_GRANTED_PRIVILEGE_COUNT = "com.zhxh.admin.dao.GET_BROTHER_GRANTED_PRIVILEGE_COUNT";
    protected final static String SQL_DELETE_ROLE_SUB_PROGRAM_PRIVILEGE = "com.zhxh.admin.dao.DELETE_ROLE_SUB_PROGRAM_PRIVILEGE";
    
}
