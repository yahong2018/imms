package com.zhxh.admin.controller;

import com.zhxh.admin.entity.RolePrivilege;
import com.zhxh.admin.entity.SystemProgram;
import com.zhxh.admin.entity.SystemUser;
import com.zhxh.admin.logic.AuthenticateLogic;
import com.zhxh.admin.logic.MainPageLogic;
import com.zhxh.admin.logic.SystemProgramLogic;
import com.zhxh.admin.logic.SystemUserLogic;
import com.zhxh.admin.vo.SystemMenu;
import com.zhxh.admin.vo.SystemProgramWithChildren;
import com.zhxh.admin.vo.SystemUserWithPrivilege;
import com.zhxh.core.web.ExtJsResult;
import com.zhxh.core.web.ListRequest;
import com.zhxh.core.web.ListRequestBaseHandler;
import com.zhxh.core.web.ListRequestProcessHandler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

@Controller
@RequestMapping("/mainPage")
public class MainPageController {
	
	private final ListRequestProcessHandler listRequestProcessHandler = new ListRequestProcessHandler();
    @Resource(name = "mainPageLogic")
    private MainPageLogic mainPageLogic;

    @Resource(name = "authenticateLogic")
    private AuthenticateLogic authenticateLogic;

    @Resource(name = "systemUserLogic")
    private SystemUserLogic systemUserLogic;
    
    @Resource(name = "systemProgramLogic")
    private SystemProgramLogic systemProgramLogic;

    @RequestMapping("getUserMenu.handler")
    @ResponseBody
    public List<SystemMenu> getUserMenu() {
        return mainPageLogic.getCurrentUserMenu();
    }

    @RequestMapping("getCurrentLogin.handler")
    @ResponseBody
    public SystemUserWithPrivilege getCurrentUser() {
        SystemUser result = authenticateLogic.getCurrentLogin();
        if(result==null){
            return null;
        }
        result.setPassword("");
        List<RolePrivilege> privileges = systemUserLogic.getUserAllPrivileges(result.getUserId());
        SystemUserWithPrivilege systemUserWithPrivilege = new SystemUserWithPrivilege();
        SystemUserWithPrivilege.copy(result,systemUserWithPrivilege);
        systemUserWithPrivilege.setPrivilegeList(privileges);

        return systemUserWithPrivilege;
    }
    
    @RequestMapping("getAllMenu.handler")
	@ResponseBody
	public List<SystemProgramWithChildren> getAll(){
        return  systemProgramLogic.getAllWithChildren();
    }

    @RequestMapping("getAllByPage.handler")
    @ResponseBody
    public ExtJsResult getAllByPage(HttpServletRequest request, HttpServletResponse response) {
        return listRequestProcessHandler.getListFromHttpRequest(request, new ListRequestBaseHandler() {
            @Override
            public List getByRequest(ListRequest listRequest) {
                return systemProgramLogic.getPageList(listRequest.toMap(), null);
            }

            @Override
            public int getRequestListCount(ListRequest listRequest) {
                return systemProgramLogic.getPageListCount(listRequest.toMap(), null);
            }
        });
    }
}
