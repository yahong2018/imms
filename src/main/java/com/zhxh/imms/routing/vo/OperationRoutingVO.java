package com.zhxh.imms.routing.vo;

import com.zhxh.imms.routing.entity.OperationRouting;

public class OperationRoutingVO extends OperationRouting {
    private String operationNo;
    private String operationName;
    private String operatorUserId;

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

    public String getOperatorUserId() {
        return operatorUserId;
    }

    public void setOperatorUserId(String operatorUserId) {
        this.operatorUserId = operatorUserId;
    }
}
