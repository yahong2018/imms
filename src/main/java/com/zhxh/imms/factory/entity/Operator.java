package com.zhxh.imms.factory.entity;

import com.zhxh.core.data.EntityObject;

public class Operator extends EntityObject {
    private String operatorId;
    private String operatorUserId;
    private String operatorPlantId;
    private String operatorSupervisorId;

    public String getOperatorId() {
        return operatorId;
    }

    public String getOperatorPlantId() {
        return operatorPlantId;
    }

    public String getOperatorSupervisorId() {
        return operatorSupervisorId;
    }

    public String getOperatorUserId() {
        return operatorUserId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public void setOperatorPlantId(String operatorPlantId) {
        this.operatorPlantId = operatorPlantId;
    }

    public void setOperatorSupervisorId(String operatorSupervisorId) {
        this.operatorSupervisorId = operatorSupervisorId;
    }

    public void setOperatorUserId(String operatorUserId) {
        this.operatorUserId = operatorUserId;
    }
}
