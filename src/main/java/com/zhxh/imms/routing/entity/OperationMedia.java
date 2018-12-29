package com.zhxh.imms.routing.entity;

import com.zhxh.core.data.EntityObject;

public class OperationMedia extends EntityObject {
    private String operationMediaId;
    private String operationMediaOperationId;
    private String operationMediaMediaId;

    public String getOperationMediaId() {
        return operationMediaId;
    }

    public void setOperationMediaId(String operationMediaId) {
        this.operationMediaId = operationMediaId;
    }

    public String getOperationMediaOperationId() {
        return operationMediaOperationId;
    }

    public void setOperationMediaOperationId(String operationMediaOperationId) {
        this.operationMediaOperationId = operationMediaOperationId;
    }

    public String getOperationMediaMediaId() {
        return operationMediaMediaId;
    }

    public void setOperationMediaMediaId(String operationMediaMediaId) {
        this.operationMediaMediaId = operationMediaMediaId;
    }
}
