package com.zhxh.imms.factory.vo;

import com.zhxh.imms.factory.entity.Machine;

public class MachineVO extends Machine {
    private String workStationNo;
    private String workStationName;
    private String machineTypeNo;
    private String machineTypeName;

    public String getWorkStationNo() {
        return workStationNo;
    }

    public void setWorkStationNo(String workStationNo) {
        this.workStationNo = workStationNo;
    }

    public String getWorkStationName() {
        return workStationName;
    }

    public void setWorkStationName(String workStationName) {
        this.workStationName = workStationName;
    }

    public String getMachineTypeNo() {
        return machineTypeNo;
    }

    public String getMachineTypeName() {
        return machineTypeName;
    }

    public void setMachineTypeNo(String machineTypeNo) {
        this.machineTypeNo = machineTypeNo;
    }

    public void setMachineTypeName(String machineTypeName) {
        this.machineTypeName = machineTypeName;
    }
}
