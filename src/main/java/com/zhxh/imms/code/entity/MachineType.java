package com.zhxh.imms.code.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.CheckUnique;
import com.zhxh.core.data.meta.TreeTable;
import com.zhxh.core.data.meta.TreeTableParentKey;

@TreeTable
public class MachineType implements EntityObject {
    private String rowId;

    @CheckUnique
    private String machineTypeNo;

    private String machineTypeName;
    private String description;

    @TreeTableParentKey
    private String parentMachineTypeId;

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
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

    public String getParentMachineTypeId() {
        return parentMachineTypeId;
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

    public void setParentMachineTypeId(String parentMachineTypeId) {
        this.parentMachineTypeId = parentMachineTypeId;
    }
}
