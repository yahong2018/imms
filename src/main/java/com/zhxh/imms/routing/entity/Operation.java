package com.zhxh.imms.routing.entity;

import com.zhxh.core.data.EntityObject;

public class Operation implements EntityObject {
    private String  operationId;
    private String  operationNo;
    private String  operationName;
    private String  operationStandardOperationProcedure;
    private String  operationMachineTypeId;
    private float   operationStandardTime;
    private float   operationStandardPrice;
    private String  operationPartType;
    private String  operationSectionType;
    private String  operationSectionName;
    private boolean operationIfOutsource;
    private String  operationQaProcedure;
    private String  operationRequirement;
    private String  operationLevel;
    private String  operationDesignPartCode;
    private String  operationPartCode;


    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

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

    public String getOperationStandardOperationProcedure() {
        return operationStandardOperationProcedure;
    }

    public void setOperationStandardOperationProcedure(String operationStandardOperationProcedure) {
        this.operationStandardOperationProcedure = operationStandardOperationProcedure;
    }

    public String getOperationMachineTypeId() {
        return operationMachineTypeId;
    }

    public void setOperationMachineTypeId(String operationMachineTypeId) {
        this.operationMachineTypeId = operationMachineTypeId;
    }

    public float getOperationStandardTime() {
        return operationStandardTime;
    }

    public void setOperationStandardTime(float operationStandardTime) {
        this.operationStandardTime = operationStandardTime;
    }

    public float getOperationStandardPrice() {
        return operationStandardPrice;
    }

    public void setOperationStandardPrice(float operationStandardPrice) {
        this.operationStandardPrice = operationStandardPrice;
    }

    public String getOperationPartType() {
        return operationPartType;
    }

    public void setOperationPartType(String operationPartType) {
        this.operationPartType = operationPartType;
    }

    public String getOperationSectionType() {
        return operationSectionType;
    }

    public void setOperationSectionType(String operationSectionType) {
        this.operationSectionType = operationSectionType;
    }

    public String getOperationSectionName() {
        return operationSectionName;
    }

    public void setOperationSectionName(String operationSectionName) {
        this.operationSectionName = operationSectionName;
    }

    public boolean isOperationIfOutsource() {
        return operationIfOutsource;
    }

    public void setOperationIfOutsource(boolean operationIfOutsource) {
        this.operationIfOutsource = operationIfOutsource;
    }

    public String getOperationQaProcedure() {
        return operationQaProcedure;
    }

    public void setOperationQaProcedure(String operationQaProcedure) {
        this.operationQaProcedure = operationQaProcedure;
    }

    public String getOperationRequirement() {
        return operationRequirement;
    }

    public void setOperationRequirement(String operationRequirement) {
        this.operationRequirement = operationRequirement;
    }

    public String getOperationLevel() {
        return operationLevel;
    }

    public void setOperationLevel(String operationLevel) {
        this.operationLevel = operationLevel;
    }

    public String getOperationDesignPartCode() {
        return operationDesignPartCode;
    }

    public void setOperationDesignPartCode(String operationDesignPartCode) {
        this.operationDesignPartCode = operationDesignPartCode;
    }

    public String getOperationPartCode() {
        return operationPartCode;
    }

    public void setOperationPartCode(String operationPartCode) {
        this.operationPartCode = operationPartCode;
    }
}
