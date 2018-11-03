package com.zhxh.admin.filters;

import com.zhxh.admin.entity.SystemUser;
import com.zhxh.admin.logic.AuthenticateLogic;
import com.zhxh.admin.logic.SystemUserLogic;
import com.zhxh.core.env.SysEnv;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			if (request instanceof HttpServletRequest) {
				HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			
				String redirectUrl = "";
				String url = httpServletRequest.getRequestURI();

				if (!url.contains(SysEnv.URL_LOGIN_PAGE)) {
					SystemUserLogic systemUserLogic = (SystemUserLogic)SysEnv.getCurrent().getContext().getBean("systemUserLogic");
					AuthenticateLogic authenticateLogic =(AuthenticateLogic) SysEnv.getCurrent().getContext().getBean("authenticateLogic");
					SystemUser currentLogin = authenticateLogic.getCurrentLogin();
					if(currentLogin==null /* 没有登录 */
							|| !systemUserLogic.canRun(currentLogin.getUserId(), url)/* 当前用户没有权限 */) {
						redirectUrl = SysEnv.URL_APP_ROOT + SysEnv.URL_LOGIN_PAGE;
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
