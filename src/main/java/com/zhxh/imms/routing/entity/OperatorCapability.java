package com.zhxh.imms.routing.entity;

import com.zhxh.core.data.EntityObject;

public class OperatorCapability implements EntityObject {
    private String operatorCapabilityId;
    private String operatorCapabilityOperatorId;
    private String operatorCapabilityOperationId;
    private String operatorCapabilityLevel;

    public String getOperatorCapabilityId() {
        return operatorCapabilityId;
    }

    public void setOperatorCapabilityId(String operatorCapabilityId) {
        this.operatorCapabilityId = operatorCapabilityId;
    }

    public String getOperatorCapabilityOperatorId() {
        return operatorCapabilityOperatorId;
    }

    public void setOperatorCapabilityOperatorId(String operatorCapabilityOperatorId) {
        this.operatorCapabilityOperatorId = operatorCapabilityOperatorId;
    }

    public String getOperatorCapabilityOperationId() {
        return operatorCapabilityOperationId;
    }

    public void setOperatorCapabilityOperationId(String operatorCapabilityOperationId) {
        this.operatorCapabilityOperationId = operatorCapabilityOperationId;
    }

    public String getOperatorCapabilityLevel() {
        return operatorCapabilityLevel;
    }

    public void setOperatorCapabilityLevel(String operatorCapabilityLevel) {
        this.operatorCapabilityLevel = operatorCapabilityLevel;
    }
}
