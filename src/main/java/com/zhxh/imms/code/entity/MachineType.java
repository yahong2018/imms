package com.zhxh.imms.code.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.AutoGeneration;
import com.zhxh.core.data.meta.annotation.CheckUnique;
import com.zhxh.core.data.meta.annotation.TreeTable;
import com.zhxh.core.data.meta.annotation.TreeTableParentKey;

import java.util.UUID;

@TreeTable
public class MachineType implements EntityObject {
    @AutoGeneration
    private String machineTypeId;

    @CheckUnique
    private String machineTypeNo;

    private String machineTypeName;
    private String machineTypeDescription;

    @TreeTableParentKey
    private String parentMachineTypeId;


    public MachineType(){
        this.machineTypeId = UUID.randomUUID().toString();
    }

    public String getMachineTypeId() {
        return machineTypeId;
    }

    public void setMachineTypeId(String machineTypeId) {
        this.machineTypeId = machineTypeId;
    }

    public String getMachineTypeNo() {
        return machineTypeNo;
    }

    public String getMachineTypeName() {
        return machineTypeName;
    }

    public String getParentMachineTypeId() {
        return parentMachineTypeId;
    }

    public void setMachineTypeNo(String machineTypeNo) {
        this.machineTypeNo = machineTypeNo;
    }

    public void setMachineTypeName(String machineTypeName) {
        this.machineTypeName = machineTypeName;
    }

    public void setParentMachineTypeId(String parentMachineTypeId) {
        this.parentMachineTypeId = parentMachineTypeId;
    }

    public String getMachineTypeDescription() {
        return machineTypeDescription;
    }

    public void setMachineTypeDescription(String machineTypeDescription) {
        this.machineTypeDescription = machineTypeDescription;
    }
}
