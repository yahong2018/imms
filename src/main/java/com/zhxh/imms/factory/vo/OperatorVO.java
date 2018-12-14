package com.zhxh.imms.factory.vo;

import com.zhxh.imms.factory.entity.Operator;

public class OperatorVO extends Operator {
    private String operatorName;
    private String supervisorName;

    public String getOperatorName() {
        return operatorName;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }
}
