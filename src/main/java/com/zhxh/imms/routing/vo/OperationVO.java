package com.zhxh.imms.routing.vo;

import com.zhxh.imms.routing.entity.Operation;

public class OperationVO extends Operation {
    private String machineTypeNo;
    private String machineTypeName;

    public String getMachineTypeNo() {
        return machineTypeNo;
    }

    public String getMachineTypeName() {
        return machineTypeName;
    }

    public void setMachineTypeName(String machineTypeName) {
        this.machineTypeName = machineTypeName;
    }

    public void setMachineTypeNo(String machineTypeNo) {
        this.machineTypeNo = machineTypeNo;
    }
}
