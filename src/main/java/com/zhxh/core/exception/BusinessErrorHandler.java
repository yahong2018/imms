package com.zhxh.core.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class BusinessErrorHandler {

    @ExceptionHandler(BusinessException.class)
    public String defaultExceptionHandler(HttpServletRequest request, Exception e) {
        return "error/500-Business";
    }
}
