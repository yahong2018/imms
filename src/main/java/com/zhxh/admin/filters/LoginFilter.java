package com.zhxh.admin.filters;

import com.zhxh.admin.entity.SystemUser;
import com.zhxh.admin.logic.AuthenticateLogic;
import com.zhxh.admin.logic.SystemUserLogic;
import com.zhxh.core.env.SysEnv;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@ServletComponentScan
@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {
	@Resource(name="systemUserLogic")
	private SystemUserLogic systemUserLogic;

	@Resource(name="authenticateLogic")
	private AuthenticateLogic authenticateLogic;

	@Override
	public void init(FilterConfig filterConfig) {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			if (request instanceof HttpServletRequest) {
				HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			
				String redirectUrl = "";
				String url = httpServletRequest.getRequestURI();
				if(!"/".equalsIgnoreCase(url)){
					chain.doFilter(request, response);
					return;
				}

				if (!url.contains(SysEnv.getUrlLoginPage())) {
					SystemUser currentLogin = authenticateLogic.getCurrentLogin();
					if(currentLogin==null /* 没有登录 */
							|| !systemUserLogic.canRun(currentLogin.getUserId(), url)/* 当前用户没有权限 */) {
						redirectUrl = SysEnv.getAppRoot() + SysEnv.getUrlLoginPage();
					}
				}
				if (!redirectUrl.isEmpty()) {
					HttpServletResponse httpServletResponse = (HttpServletResponse) response;
					httpServletResponse.sendRedirect(redirectUrl);
					return;
				}
			}
			chain.doFilter(request, response);
		} finally {
		}
	}

	@Override
	public void destroy() {
	}

}
