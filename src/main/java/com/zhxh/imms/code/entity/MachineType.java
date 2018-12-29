package com.zhxh.imms.code.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.AutoGeneration;
import com.zhxh.core.data.meta.annotation.CheckUnique;
import com.zhxh.core.data.meta.annotation.TreeTable;
import com.zhxh.core.data.meta.annotation.TreeTableParentKey;

import java.util.UUID;

@TreeTable
public class MachineType extends EntityObject {
    @AutoGeneration
    private String machineTypeId;

    @CheckUnique
    private String machineTypeNo;

    private String machineTypeName;
    private String machineTypeDescription;

    @TreeTableParentKey
    private String parentMachineTypeId;

    private String machineTypeNoPath;
    private String machineTypeNamePath;

    public String getMachineTypeNoPath() {
        return machineTypeNoPath;
    }

    public String getMachineTypeNamePath() {
        return machineTypeNamePath;
    }

    public void setMachineTypeNoPath(String machineTypeNoPath) {
        this.machineTypeNoPath = machineTypeNoPath;
    }

    public void setMachineTypeNamePath(String machineTypeNamePath) {
        this.machineTypeNamePath = machineTypeNamePath;
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
