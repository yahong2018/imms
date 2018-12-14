package com.zhxh.imms.factory.entity;

import com.zhxh.core.data.EntityObject;

public class Machine implements EntityObject {
    private String machineId;
    private String machineNo;
    private String machineName;
    private String machineTypeId;
    private String machineStatus;
    private String machineDescription;
    private String machineWorkStationId;

    public String getMachineId() {
        return machineId;
    }

    public String getMachineNo() {
        return machineNo;
    }

    public String getMachineName() {
        return machineName;
    }

    public String getMachineTypeId() {
        return machineTypeId;
    }

    public String getMachineStatus() {
        return machineStatus;
    }

    public String getMachineWorkStationId() {
        return machineWorkStationId;
    }

    public String getMachineDescription() {
        return machineDescription;
    }

    public void setMachineDescription(String machineDescription) {
        this.machineDescription = machineDescription;
    }

    public void setMachineId(String machineId) {
        this.machineId = machineId;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public void setMachineNo(String machineNo) {
        this.machineNo = machineNo;
    }

    public void setMachineStatus(String machineStatus) {
        this.machineStatus = machineStatus;
    }

    public void setMachineTypeId(String machineTypeId) {
        this.machineTypeId = machineTypeId;
    }

    public void setMachineWorkStationId(String machineWorkStationId) {
        this.machineWorkStationId = machineWorkStationId;
    }
}
