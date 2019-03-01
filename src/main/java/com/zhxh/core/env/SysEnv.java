package com.zhxh.core.env;

import com.zhxh.core.backservice.ServiceManager;
import com.zhxh.core.utils.PropertyLoader;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SysEnv implements ApplicationContextAware {
    public final static int ENVIRONMENT_MODE_DEV=0;
    public final static int ENVIRONMENT_MODE_TEST=1;
    public final static int ENVIRONMENT_MODE_PRE_LIVE=2;
    public final static int ENVIRONMENT_MODE_LIVE=3;
    public final static int ENVIRONMENT_MODE_SIMULATE=9;

    private static String urlLoginPage = "";
    private static String urlAppIndex = "";
    private static String appAbsoluteRootPath = "";
    private static String appRoot = "";
    private static String systemTitle = "";
    private static String shellExecuteName;
    private static String fileUploadPath = "";

    private static ApplicationContext applicationContext;
    private static ServiceManager serviceManager;

    private static Map<String, String> errorsMessageHolder;
    private static Map<String, String> entityFieldLabelHolder;
    private static int environmentMode = ENVIRONMENT_MODE_DEV;   // 0.开发      1.测试    2.预生产    3.生产    9.仿真

    private static final String configLocation = "classpath:config/settings/env.properties";

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SysEnv.applicationContext == null) {
            SysEnv.applicationContext = applicationContext;
        }

        Map<String, String> propertyMap = PropertyLoader.getPropertyMap(configLocation);
        urlLoginPage = propertyMap.get("sysenv.urlLoginPage");
        urlAppIndex = propertyMap.get("sysenv.urlAppIndex");
        appAbsoluteRootPath = propertyMap.get("sysenv.appAbsoluteRootPath");
        appRoot = propertyMap.get("sysenv.appRoot");
        systemTitle = propertyMap.get("sysenv.systemTitle");
        shellExecuteName = propertyMap.get("sysenv.shellExecuteName");
        fileUploadPath = propertyMap.get("sysenv.fileUploadPath");

        String messageErrorLocation = propertyMap.get("sysenv.messageErrorLocation");
        errorsMessageHolder = PropertyLoader.getPropertyMap(messageErrorLocation);
        String fieldLabelLocation = propertyMap.get("sysenv.fieldLabelLocation");
        entityFieldLabelHolder = PropertyLoader.getPropertyMap(fieldLabelLocation);

        String strEnvironmentMode = propertyMap.get("sysenv.environmentMode");
        if (StringUtils.isNotEmpty(strEnvironmentMode)) {
            environmentMode = Integer.parseInt(strEnvironmentMode);
        }
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static ServiceManager getServiceManager() {
        return serviceManager;
    }

    public static String getShellExecuteName() {
        return shellExecuteName;
    }

    public static String getUrlLoginPage() {
        return urlLoginPage;
    }

    public static String getUrlAppIndex() {
        return urlAppIndex;
    }

    public static String getAppAbsoluteRootPath() {
        return appAbsoluteRootPath;
    }

    public static String getAppRoot() {
        return appRoot;
    }

    public static String getFileUploadPath() {
        return fileUploadPath;
    }

    public static String getSystemTitle() {
        return systemTitle;
    }

    public static int getEnvironmentMode() {
        return environmentMode;
    }


    public static String getErrorMessage(String errorCode) {
        if (errorsMessageHolder.containsKey(errorCode)) {
            return errorsMessageHolder.get(errorCode);
        }
        return "";
    }

    public static String getFieldLabel(String fieldName) {
        if (entityFieldLabelHolder.containsKey(fieldName)) {
            return entityFieldLabelHolder.get(fieldName);
        }
        int index = fieldName.lastIndexOf(".");
        return fieldName.substring(index + 1);
    }

    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }

}
