package com.zhxh.admin.logic;

import static com.zhxh.core.exception.ExceptionManager.throwException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.zhxh.admin.dao.ProgramPrivilegeDAO;
import com.zhxh.admin.dao.RolePrivilegeDAO;
import com.zhxh.admin.entity.ProgramPrivilege;
import com.zhxh.core.exception.ErrorCode;

@Component("programPrivilegeLogic")
public class ProgramPrivilegeLogic {
	@Resource(name="programPrivilegeDAO")
	ProgramPrivilegeDAO programPrivilegeDAO;
	
	 @Resource(name = "rolePrivilegeDAO")
    private RolePrivilegeDAO rolePrivilegeDAO;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional(rollbackFor = Exception.class)
	public void create(ProgramPrivilege item) throws Exception {
		if (StringUtils.isEmpty(item.getProgramId())) {
			throwException(ErrorCode.PROGRAM_ID_IS_NULL, "");
		}
		// 校验编码是否已存在
		Map parameters = new HashMap();
		parameters.put("programId", item.getProgramId());
		parameters.put("privilegeId", item.getPrivilegeId());
		String where = "PROGRAM_ID =#{programId} and PRIVILEGE_ID =#{privilegeId}";
		Map listMap = new HashMap();
		listMap.put("where", where);
		List<ProgramPrivilege> list = programPrivilegeDAO.getList(listMap, parameters);
		if (list != null && list.size() > 0) {
			throwException(ErrorCode.ERROR_DATA_ALREADY_EXISTS,"按钮代码",item.getPrivilegeId());
		}
		item.setProgramPrivilegeId(0);
		//新增一条 role_privileges
		 programPrivilegeDAO.insert(item);
		 ProgramPrivilege programPrivilege = programPrivilegeDAO.getProgramPrivilegeByProgramIdAndPrivilegeId(item.getProgramId(), item.getPrivilegeId());
		 item.setProgramPrivilegeId(programPrivilege.getProgramPrivilegeId());
	}

	@Transactional(rollbackFor = Exception.class)
	public int update(ProgramPrivilege item) throws Exception {
		return programPrivilegeDAO.update(item);
	}

	@Transactional(rollbackFor = Exception.class)
	public int delete(Object[] ids) throws Exception {
		for (Object id : ids) {
				ProgramPrivilege item = programPrivilegeDAO.getById(id);
				int result = rolePrivilegeDAO.removeRolePrivilegeByProgramIdAndPrivilegeId(item.getProgramId(),item.getPrivilegeId());
		}
		for (Object id : ids) {
			int result = programPrivilegeDAO.deleteById(id);
			if (result != 1) {
				throwException(ErrorCode.ERROR_UNKNOWN_EXCEPTION,  "数据删除失败！");
			}
		}
		
		return ids.length;
	}

	 public List<ProgramPrivilege> getProgramPrivilegeByProgramId(String programId) {
		 return programPrivilegeDAO.getProgramPrivilegeByProgramId(programId);
    }

	public List getPageList(Map map, Map parameters) {
		return programPrivilegeDAO.getPageList(map, parameters);
	}

	public int getPageListCount(Map map, Map parameters) {
		return programPrivilegeDAO.getPageListCount(map, parameters);
	}
	
	public List getPageListByProgramId(Map map, Map parameters) {
		return programPrivilegeDAO.getPageListByProgramId(map, parameters);
	}

	public int getPageListCountByProgramId(Map map, Map parameters) {
		return programPrivilegeDAO.getPageListCountByProgramId(map, parameters);
	}
}
