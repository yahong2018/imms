package com.zhxh.admin.controller;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import com.zhxh.admin.entity.RolePrivilege;
import com.zhxh.admin.vo.ProgramPrivilegeVO;
import com.zhxh.admin.vo.SystemMenuWithPrivilege;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhxh.admin.entity.SystemRole;
import com.zhxh.admin.logic.SystemRoleLogic;

@Controller
@RequestMapping("/admin/systemRoles")
public class SystemRoleController {
	@Resource(name="systemRoleLogic")
	private SystemRoleLogic systemRoleLogic;
	
	@RequestMapping("getAll.handler")
	@ResponseBody
	public List<SystemRole> getAll(){
		return systemRoleLogic.getAll();
	}

	@RequestMapping("getRolePrivileges.handler")
	@ResponseBody
	public List<RolePrivilege> getRolePrivileges(String roleId){
		return  systemRoleLogic.getRolePrivileges(roleId);
	}

	@RequestMapping("getAllMenuWithPrivilege.handler")
	@ResponseBody
	public List<SystemMenuWithPrivilege> getAllMenuWithPrivilege(){
		return systemRoleLogic.getSystemMenuWithPrivilege();
	}

	@RequestMapping("getRoleMenuWithPrivilege.handler")
	@ResponseBody
	public List<SystemMenuWithPrivilege> getRoleMenuWithPrivilege(String roleId){
		return systemRoleLogic.getRoleMenuWithPrivilege(roleId);
	}

	@RequestMapping("insert.handler")
	@ResponseBody
	public SystemRole insert(SystemRole role){
		systemRoleLogic.insert(role);

		return role;
	}

	@RequestMapping("update.handler")
	@ResponseBody
	public SystemRole update(SystemRole role)  {
		systemRoleLogic.update(role);
		return role;
	}

	@RequestMapping("delete.handler")
	@ResponseBody
	public int delete(@RequestBody String[] roleIdList) {
		return systemRoleLogic.delete(roleIdList);
	}

	@RequestMapping("updateRolePrivileges.handler")
	@ResponseBody
	public int updateRolePrivileges(String roleId,@RequestBody ProgramPrivilegeVO[] privilegeList) {
		systemRoleLogic.updatePrivileges(roleId,privilegeList);
		return 0;
	}
}
