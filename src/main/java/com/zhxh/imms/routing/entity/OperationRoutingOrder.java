package com.zhxh.imms.routing.entity;

import com.zhxh.core.data.EntityObject;

public class OperationRoutingOrder extends EntityObject {
    private String operationRoutingOrderId;
    private String operationRoutingOrderNo;
    private String operationRoutingType;

    public String getOperationRoutingOrderNo() {
        return operationRoutingOrderNo;
    }

    public void setOperationRoutingOrderNo(String operationRoutingOrderNo) {
        this.operationRoutingOrderNo = operationRoutingOrderNo;
    }

    public String getOperationRoutingType() {
        return operationRoutingType;
    }

    public void setOperationRoutingType(String operationRoutingType) {
        this.operationRoutingType = operationRoutingType;
    }


    public String getOperationRoutingOrderId() {
        return operationRoutingOrderId;
    }

    public void setOperationRoutingOrderId(String operationRoutingOrderId) {
        this.operationRoutingOrderId = operationRoutingOrderId;
    }
}