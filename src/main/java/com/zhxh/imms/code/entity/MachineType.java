package com.zhxh.imms.code.entity;

import com.zhxh.core.data.EntityObject;

public class MachineType extends EntityObject {
    private long id;
    private String machineTypeNo;
    private String machineTypeName;
    private String description;
    private long parentMachineTypeId;

    public long getId() {
        return id;
    }

    public String getMachineTypeNo() {
        return machineTypeNo;
    }

    public String getMachineTypeName() {
        return machineTypeName;
    }

    public String getDescription() {
        return description;
    }

    public long getParentMachineTypeId() {
        return parentMachineTypeId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMachineTypeNo(String machineTypeNo) {
        this.machineTypeNo = machineTypeNo;
    }

    public void setMachineTypeName(String machineTypeName) {
        this.machineTypeName = machineTypeName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setParentMachineTypeId(long parentMachineTypeId) {
        this.parentMachineTypeId = parentMachineTypeId;
    }
}
