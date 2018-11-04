package com.zhxh.admin.logic;

import static com.zhxh.core.exception.ExceptionHelper.throwException;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
