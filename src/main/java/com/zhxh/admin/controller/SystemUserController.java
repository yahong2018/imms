package com.zhxh.admin.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhxh.admin.entity.RoleUser;
import com.zhxh.admin.entity.SystemRole;
import com.zhxh.admin.entity.SystemUser;
import com.zhxh.admin.logic.RoleUserLogic;
import com.zhxh.admin.logic.SystemUserLogic;
import com.zhxh.core.web.ExtJsResult;
import com.zhxh.core.web.ListRequest;
import com.zhxh.core.web.ListRequestBaseHandler;
import com.zhxh.core.web.ListRequestProcessHandler;

@Controller
@RequestMapping("/admin/systemUsers")
public class SystemUserController {
    @Resource(name = "systemUserLogic")
    private SystemUserLogic systemUserLogic;
    
    @Resource(name="roleUserLogic")
    private RoleUserLogic roleUserLogic;

    @InitBinder
    public void intDate(WebDataBinder dataBinder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，false:不能为空
    }

    private final ListRequestProcessHandler listRequestProcessHandler = new ListRequestProcessHandler();

    @RequestMapping("getAllUsers.handler")
    @ResponseBody
    public ExtJsResult getAllUsers(HttpServletRequest request, HttpServletResponse response) {
        return listRequestProcessHandler.getListFromHttpRequest(request, new ListRequestBaseHandler() {
            @Override
            public List getByRequest(ListRequest listRequest) {
                return systemUserLogic.getSystemUserDAO().getPageList(listRequest.toMap(), null);
            }

            @Override
            public int getRequestListCount(ListRequest listRequest) {
                return systemUserLogic.getSystemUserDAO().getPageListCount(listRequest.toMap(), null);
            }
        });
    }

    @RequestMapping("openLoginAccount.handler")
    @ResponseBody
    public SystemUser openLoginAccount(SystemUser user) throws Exception {
        systemUserLogic.openLoginAccount(user);
        return user;
    }

    @RequestMapping("update.handler")
    @ResponseBody
    public SystemUser update(SystemUser user) throws Exception {
        systemUserLogic.update(user);
        return user;
    }

    @RequestMapping("delete.handler")
    @ResponseBody
    public int delete(@RequestBody String[] userIdList) throws Exception {    	
        return systemUserLogic.delete(userIdList);
    }

    @RequestMapping("disableUser.handler")
    @ResponseBody
    public int disableUser(String userId) throws Exception {
       return systemUserLogic.disableUser(userId);
    }

    @RequestMapping("enableUser.handler")
    @ResponseBody
    public int enableUser(String userId) throws Exception {
        return systemUserLogic.enableUser(userId);
    }

    @RequestMapping("resetPassword.handler")
    @ResponseBody
    public int resetPassword(String userId) throws Exception {
        return systemUserLogic.resetPassword(userId);
    }

    @RequestMapping("getUserRoles.handler")
    @ResponseBody
    public List<SystemRole> getUserRoles(String userId){
        return systemUserLogic.getUserRoles(userId);
    }
    
    @RequestMapping("updateUserRoles.handler")
    @ResponseBody
    public int updateRoles(String userId, @RequestBody RoleUser[] roleUsers) throws Exception {
    	return roleUserLogic.updateUserRoles(userId, roleUsers);
    }

    @RequestMapping("addRole.handler")
    @ResponseBody
    public int addRole(String userId,String roleId) throws Exception {
        return systemUserLogic.addRole(userId,roleId);
    }

    @RequestMapping("removeRole.handler")
    @ResponseBody
    public int removeRole(String userId,String roleId) throws Exception {
        return systemUserLogic.removeRole(userId,roleId);
    }
}
