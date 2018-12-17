package com.zhxh.imms.factory.vo;

import com.zhxh.imms.factory.entity.Operator;

public class OperatorVO extends Operator {
    private String operatorName;
    private String supervisorUserId;
    private String supervisorName;

    public String getOperatorName() {
        return operatorName;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public String getSupervisorUserId() {
        return supervisorUserId;
    }

    public void setSupervisorUserId(String supervisorUserId) {
        this.supervisorUserId = supervisorUserId;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }
}
