package com.zhxh.core.web;

import com.zhxh.core.GlobalConstants;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiCallResult {
    private int code = GlobalConstants.RESULT_CODE_DEFAULT;
    private String message;

    public final static ApiCallResult ERROR(String errorMessage){
        ApiCallResult result = new ApiCallResult();
        result.setCode(GlobalConstants.RESULT_CODE_ERROR);
        result.setMessage(errorMessage);

        return result;
    }

    public final static ApiCallResult DEFAULT=new ApiCallResult();
}
