package com.zhxh.admin.dao;

import com.zhxh.admin.entity.ProgramPrivilege;
import com.zhxh.core.data.BaseDAOWithEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("programPrivilegeDAO")
public class ProgramPrivilegeDAO extends BaseDAOWithEntity<ProgramPrivilege> {
    public List<ProgramPrivilege> getUserProgramPrivielge(String userId) {
        Map parameters = new HashMap();
        parameters.put("userId", userId);
        return this.getSqlHelper().getSqlSession().selectList(SQL_GET_USER_PROGRAM_PRIVILEGE, parameters);
    }

    public ProgramPrivilege getProgramRunPrivilege(String programId) {
        String where = "program_id=#{programId} and privilege_id=#{privilegeId}";
        Map parameters = new HashMap();
        parameters.put("programId", programId);
        parameters.put("privilegeId", ProgramPrivilege.PROGRAM_RUN);

        return this.getOne(where, parameters);
    }
    
    public List<ProgramPrivilege> getProgramPrivilegeByProgramId(String programId) {
        String where = "program_id=#{programId}";
        Map parameters = new HashMap();
        parameters.put("programId", programId);
        return this.getSqlHelper().getSqlSession().selectList(SQL_GET_PROGRAM_PRIVILEGE_BY_PROGRAM_ID, parameters);
    }
    
    public int removeProgramPrivilegeByProgramId(String programId){
	    String where = " where program_id=#{programId}";
	    Map parameters = new HashMap();
	    parameters.put("programId",programId);
	    return this.deleteByWhere(where,parameters);
    }
    
    public List getPageListByProgramId(Map map, Map parameters) {
         map.put("programId", parameters.get("programId"));
         return this.getSqlHelper().getSqlSession().selectList(SQL_GET_PROGRAM_PRIVILEGE_BY_PROGRAM_ID, map);
	}

	public int getPageListCountByProgramId(Map map,Map parameters) {
		map.put("programId", parameters.get("programId"));
		Map<Object,Object> total = this.getSqlHelper().getSqlSession().selectOne(SQL_GET_PROGRAM_PRIVILEGE_BY_PROGRAM_ID_COUNT, map);
		return Integer.parseInt(total == null ? "0" : total.get("TOTAL").toString()) ; 
	}
	
	public ProgramPrivilege getProgramPrivilegeByProgramIdAndPrivilegeId(String programId,String privilegeId) {
        String where = "program_id=#{programId} and privilege_id=#{privilegeId}"; 
        Map parameters = new HashMap();
        parameters.put("programId", programId);
        parameters.put("privilegeId", privilegeId);
        return this.getOne(where, parameters);
    }

    public final static String SQL_GET_USER_PROGRAM_PRIVILEGE = "com.zhxh.admin.dao.GET_USER_PROGRAM_PRIVILEGE";
    public final static String SQL_GET_PROGRAM_PRIVILEGE_BY_PROGRAM_ID = "com.zhxh.admin.dao.GET_PROGRAM_PRIVILEGE_BY_PROGRAM_ID";
    public final static String SQL_GET_PROGRAM_PRIVILEGE_BY_PROGRAM_ID_COUNT = "com.zhxh.admin.dao.GET_PROGRAM_PRIVILEGE_BY_PROGRAM_ID_COUNT";

}
