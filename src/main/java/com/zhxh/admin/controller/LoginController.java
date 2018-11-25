package com.zhxh.admin.controller;

import com.zhxh.admin.entity.SystemUser;
import com.zhxh.admin.logic.AuthenticateLogic;
import com.zhxh.core.env.SysEnv;
import com.zhxh.core.utils.Logger;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class LoginController {
    @Resource(name = "authenticateLogic")
    AuthenticateLogic authenticateLogic;

    @RequestMapping("/login")
    public String login() {
        return "admin/login";
    }

    @RequestMapping(value = "/login/doLogin", method = RequestMethod.POST)
    public String doLogin(Model model, String userId, String password) {
        SystemUser user = new SystemUser();
        user.setUserId(userId);
        user.setPassword(password);
        try {
            authenticateLogic.authenticate(user);
            String url = SysEnv.getAppRoot() + SysEnv.getUrlAppIndex();
            if (StringUtils.isEmpty(url)) {
                url = "/";
            }
            return "redirect:" + url;
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            model.addAttribute("errorMessage", errorMessage);
            Logger.info(errorMessage);
        }

        return "admin/login";
    }
}
