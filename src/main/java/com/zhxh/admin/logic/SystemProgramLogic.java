package com.zhxh.admin.logic;

import static com.zhxh.core.exception.ExceptionManager.throwException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import com.zhxh.admin.vo.SystemProgramWithChildren;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zhxh.admin.dao.ProgramPrivilegeDAO;
import com.zhxh.admin.dao.RolePrivilegeDAO;
import com.zhxh.admin.dao.SystemProgramDAO;
import com.zhxh.admin.entity.SystemProgram;
import com.zhxh.core.data.EntityObject;
import com.zhxh.core.exception.ErrorCode;

@Component("systemProgramLogic")
public class SystemProgramLogic {
	@Resource(name="systemProgramDAO")
	SystemProgramDAO systemProgramDAO;
	
	@Resource(name="programPrivilegeDAO")
	ProgramPrivilegeDAO programPrivilegeDAO;
	
	@Resource(name = "rolePrivilegeDAO")
    private RolePrivilegeDAO rolePrivilegeDAO;
	
	@Transactional(rollbackFor = Exception.class)
	public int create(SystemProgram item) throws Exception {
		
		if (item.getParent() == null || "".equals(item.getParent())) {
			item.setParent(item.getParent());
		}
		// 校验编码是否已存在
		Map parameters = new HashMap();
		parameters.put("programId", item.getProgramId());
		String where = "PROGRAM_ID =#{programId}";
		Map listMap = new HashMap();
		listMap.put("where", where);
		List<SystemProgram> list = systemProgramDAO.getList(listMap, parameters);
		if (list != null && list.size() > 0) {
			throwException(ErrorCode.PROGRAM_ID, "");
		}
		
		return systemProgramDAO.insert(item);
	}

	@Transactional(rollbackFor = Exception.class)
	public int update(SystemProgram item) throws Exception {
		return systemProgramDAO.update(item);
	}

	@Transactional(rollbackFor = Exception.class)
	public int delete(Object[] ids) throws Exception {
		Map parameters = new HashMap();
		String departmentWhere = "PARENT=#{programId} and (PROGRAM_ID != PARENT)";
		Map departmentMap = new HashMap();
		departmentMap.put("where", departmentWhere);
		String where = "PROGRAM_ID=#{programId}";
		Map listMap = new HashMap();
		listMap.put("where", where);
		for (Object id : ids) {
			parameters.put("programId", id);
			//校验是否有下级菜单
			List<SystemProgram> list = systemProgramDAO.getList(departmentMap, parameters);
			if (list != null && list.size() > 0) {
				throwException(ErrorCode.DELECT_PROGRAM_ID, "");
			}		
			//删除  级联 program_privileges  通过programId
			programPrivilegeDAO.removeProgramPrivilegeByProgramId(id.toString());
			  //删除  级联  role_privileges  通过programId
			rolePrivilegeDAO.removeRolePrivilegeByProgramId(id.toString());
		}
		for (Object id : ids) {
			int result = systemProgramDAO.deleteById(id);
			if (result != 1) {
				throwException(ErrorCode.ERROR_UNKNOWN_EXCEPTION, "删除菜单失败");
			}
		}
		
		return ids.length;
	}

	public List<SystemProgram> getAll() {
		return systemProgramDAO.getAll();
	}

	public List getPageList(Map map, Map parameters) {
		return systemProgramDAO.getPageList(map, parameters);
	}

	public int getPageListCount(Map map, Map parameters) {
		return systemProgramDAO.getPageListCount(map, parameters);
	}
	
	 public List<SystemProgramWithChildren> getAllWithChildren() {
			List<SystemProgramWithChildren> result = new ArrayList<>();
			List<SystemProgram> systemProgramsList = systemProgramDAO.getAll();
			SystemProgram[] company = systemProgramsList.stream().filter(x -> x.getProgramId().equals(x.getParent())).toArray(SystemProgram[]::new);
			for (int a = 0; a < company.length; a++) {

				SystemProgramWithChildren companyWithChildren = new SystemProgramWithChildren();
				EntityObject.copy(company[a], companyWithChildren);
				SystemProgram[] childrenSystemProgram = systemProgramsList.stream()
						 .filter(SystemProgram::isTopMenu)
		                 .sorted(Comparator.comparing(SystemProgram::getShowOrder))
			             .toArray(SystemProgram[]::new);
				
				SystemProgramWithChildren[] children = new SystemProgramWithChildren[childrenSystemProgram.length];
				companyWithChildren.setChildren(children);

				for (int i = 0; i < children.length; i++) {
					SystemProgram child = childrenSystemProgram[i];
					SystemProgramWithChildren sub = new SystemProgramWithChildren();
					EntityObject.copy(child, sub);
					this.systemProgram2Tree(sub, systemProgramsList);

					children[i] = sub;
				}

				result.add(companyWithChildren);
			}
			return result;
		}

		private void systemProgram2Tree(SystemProgramWithChildren parent, List<SystemProgram> systemProgramsList) {
			 
			SystemProgram[] childrenSystemProgram = systemProgramsList.stream()
					 .filter(
		                        x -> x.getParent().equals(parent.getProgramId()) && (!x.getProgramId().equals(parent.getProgramId()))
		                ).sorted(Comparator.comparing(SystemProgram::getShowOrder))
		                .toArray(SystemProgram[]::new);
			SystemProgramWithChildren[] children = new SystemProgramWithChildren[childrenSystemProgram.length];
			parent.setChildren(children);
			for (int i = 0; i < children.length; i++) {
				SystemProgram child = childrenSystemProgram[i];
				SystemProgramWithChildren sub = new SystemProgramWithChildren();
				EntityObject.copy(child, sub);
				children[i] = sub;

				this.systemProgram2Tree(sub, systemProgramsList);
			}
		}
}
