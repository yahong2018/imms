package com.zhxh.core.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.zhxh.core.env.SysEnv;

public class SpringInit implements ServletContextListener {
    private static WebApplicationContext springContext;

    public SpringInit() {
        super();
    }

    public void contextInitialized(ServletContextEvent sce) {
        springContext = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
        SysEnv sysEnv = (SysEnv) springContext.getBean("sysEnv");
        SysEnv.setCurrent(sysEnv);
        sysEnv.setContext(springContext);
        sysEnv.init();        
        SysEnv.URL_APP_ROOT= springContext.getServletContext().getContextPath();
    }

    public void contextDestroyed(ServletContextEvent sce) {
        springContext = null;
    }

    public static WebApplicationContext getApplicationContext() {
        return springContext;
    }
}
