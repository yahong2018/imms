package com.zhxh.core.env;

import com.zhxh.core.backservice.ServiceManager;
import org.springframework.context.ApplicationContext;

import java.util.Map;

public class SysEnv {
    public static String URL_LOGIN_PAGE = "";
    public static String URL_APP_ABSOLUTE_ROOT = "";
    public static String URL_APP_ROOT = "";
    public static String SYSTEM_TITLE = "";
    public static String URL_APP_INDEX = "";

    private static SysEnv current;
    private ApplicationContext context;
    private ServiceManager serviceManager;
//    private PropertyPlaceholder errorsPropertyConfigurer;
//    private PropertyPlaceholder fieldsPropertyConfigurer;
//    private PropertyPlaceholder settingsPropertyConfigurer;

    public static String ATTACH_FILE_UPLOAD_PATH = "";

    private static Map<String, String> errorsPropertyConfigurer;
    private static Map<String, String> fieldsPropertyConfigurer;
    private static Map<String, String> settingsPropertyConfigurer;

    public void init() {
    }


    public static SysEnv getCurrent() {
        return SysEnv.current;
    }

    public static void setCurrent(SysEnv current) {
        SysEnv.current = current;
    }

    public ApplicationContext getContext() {
        return context;
    }

    public void setContext(ApplicationContext context) {
        this.context = context;

//        settingsPropertyConfigurer = (PropertyPlaceholder) this.context.getBean("settingsPropertyConfigurer");
//
//        URL_LOGIN_PAGE = settingsPropertyConfigurer.getProperty("URL_LOGIN_PAGE").toString();
//        URL_APP_ABSOLUTE_ROOT = settingsPropertyConfigurer.getProperty("URL_APP_ABSOLUTE_ROOT").toString();
//        URL_APP_ROOT = settingsPropertyConfigurer.getProperty("URL_APP_ROOT").toString();
//        SYSTEM_TITLE = settingsPropertyConfigurer.getProperty("SYSTEM_TITLE").toString();
//        URL_APP_INDEX = settingsPropertyConfigurer.getProperty("URL_APP_INDEX").toString();
//
//        ATTACH_FILE_UPLOAD_PATH = settingsPropertyConfigurer.getProperty("ATTACH_FILE_UPLOAD_PATH").toString();
    }

    public ServiceManager getServiceManager() {
        return serviceManager;
    }

    public void setServiceManager(ServiceManager serviceManager) {
        this.serviceManager = serviceManager;
    }

//    public synchronized PropertyPlaceholder getErrorsPropertyConfigurer() {
//        if(errorsPropertyConfigurer==null){
//            errorsPropertyConfigurer = (PropertyPlaceholder)context.getBean("errorsPropertyConfigurer");
//        }
//        return errorsPropertyConfigurer;
//    }
//
//    public synchronized PropertyPlaceholder getFieldsPropertyConfigurer(){
//        if(fieldsPropertyConfigurer==null){
//            fieldsPropertyConfigurer = (PropertyPlaceholder)context.getBean("fieldsPropertyConfigurer");
//        }
//        return fieldsPropertyConfigurer;
//    }

    private String shellExecuteName;

    public String getShellExecuteName() {
        return shellExecuteName;
    }

    public void setShellExecuteName(String shellExecuteName) {
        this.shellExecuteName = shellExecuteName;
    }

    public Map<String, String> getErrorsPropertyConfigurer() {
        return errorsPropertyConfigurer;
    }

    public void setErrorsPropertyConfigurer(Map<String, String> errorsPropertyConfigurer) {
        SysEnv.errorsPropertyConfigurer = errorsPropertyConfigurer;
    }

    public Map<String, String> getFieldsPropertyConfigurer() {
        return fieldsPropertyConfigurer;
    }

    public void setFieldsPropertyConfigurer(Map<String, String> fieldsPropertyConfigurer) {
        SysEnv.fieldsPropertyConfigurer = fieldsPropertyConfigurer;
    }

    public Map<String, String> getSettingsPropertyConfigurer() {
        return settingsPropertyConfigurer;
    }

    public void setSettingsPropertyConfigurer(Map<String, String> settingsPropertyConfigurer) {
        SysEnv.settingsPropertyConfigurer = settingsPropertyConfigurer;
    }
}
