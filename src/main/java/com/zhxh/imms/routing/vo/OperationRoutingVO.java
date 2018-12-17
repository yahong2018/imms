package com.zhxh.imms.routing.vo;

import com.zhxh.imms.routing.entity.OperationRouting;

public class OperationRoutingVO extends OperationRouting {
    private String operationNo;
    private String operationName;
    private String userId;
    private String userName;

    public String getOperationNo() {
        return operationNo;
    }

    public void setOperationNo(String operationNo) {
        this.operationNo = operationNo;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }


    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
