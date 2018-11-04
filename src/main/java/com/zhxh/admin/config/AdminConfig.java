package com.zhxh.admin.config;

import com.zhxh.admin.filters.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class AdminConfig {

  //  @Bean
    public FilterRegistrationBean registerLoginFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new LoginFilter());
        registrationBean.addUrlPatterns("/");
        registrationBean.addUrlPatterns("/login");
        registrationBean.setName("LoginCheck");
        return registrationBean;
    }
}
