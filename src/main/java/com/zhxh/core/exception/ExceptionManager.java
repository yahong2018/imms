package com.zhxh.core.exception;

import com.zhxh.core.env.SysEnv;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionManager {
    public static String exceptionStackTrace(Exception e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw, true));
        return sw.toString();
    }

    public static void throwException(ErrorCode errorCode, Object... args) throws Exception {
        String message = buildExceptionMessage(errorCode, args);
        throw new BusinessError(message);
    }

    private static String buildExceptionMessage(ErrorCode errorCode, Object... args) {
        String name = errorCode.name();

        String template = "[" + errorCode + "]:" + SysEnv.getCurrent().getErrorsPropertyConfigurer().get(name);
        return String.format(template, args);
    }
}
