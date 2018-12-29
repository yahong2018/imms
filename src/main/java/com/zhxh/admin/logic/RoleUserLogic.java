package com.zhxh.admin.logic;

import com.zhxh.admin.dao.RoleUserDAO;
import com.zhxh.admin.entity.RoleUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.zhxh.core.exception.ErrorCode.ERROR_UNKNOWN_EXCEPTION;
import static com.zhxh.core.exception.ExceptionHelper.throwException;

@Component("roleUserLogic")
public class RoleUserLogic {
	@Resource(name = "roleUserDAO")
	private RoleUserDAO roleUserDAO;

	@Transactional(rollbackFor = Exception.class)
	public int updateUserRoles(String userId, RoleUser[] roleUserList){
		for (RoleUser roleUser : roleUserList) {
			if (roleUser.getUserId().equals(userId)) {
				throwException(ERROR_UNKNOWN_EXCEPTION, "userId必须一致！");
			}
		}
		String where = " where user_id=#{userId} ";
		Map parameters = new HashMap<>();
		parameters.put("userId", userId);
		roleUserDAO.deleteByWhere(where, parameters);
		
		for (RoleUser roleUser : roleUserList) {
			if (roleUserDAO.insert(roleUser) != 1) {
				throwException(ERROR_UNKNOWN_EXCEPTION, "数据插入失败！");
			}
		}
		return roleUserList.length;
	}	
}
