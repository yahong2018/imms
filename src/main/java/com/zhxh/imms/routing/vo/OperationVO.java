package com.zhxh.imms.routing.vo;

import com.zhxh.imms.routing.entity.Operation;

public class OperationVO extends Operation {
    private String operationMachineTypeNo;
    private String operationMachineTypeName;

    public String getOperationMachineTypeNo() {
        return operationMachineTypeNo;
    }

    public void setOperationMachineTypeNo(String operationMachineTypeNo) {
        this.operationMachineTypeNo = operationMachineTypeNo;
    }

    public String getOperationMachineTypeName() {
        return operationMachineTypeName;
    }

    public void setOperationMachineTypeName(String operationMachineTypeName) {
        this.operationMachineTypeName = operationMachineTypeName;
    }
}
