package com.zhxh.imms.code.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.CheckUnique;
import com.zhxh.core.data.meta.TreeTable;
import com.zhxh.core.data.meta.TreeTableParentKey;

@TreeTable
public class MaterialType implements EntityObject {
    private String rowId;

    @CheckUnique
    private String materialTypeNo;
    private String materialTypeName;
    private String description;

    @TreeTableParentKey
    private String parentMaterialTypeId;


    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getMaterialTypeNo() {
        return materialTypeNo;
    }

    public String getMaterialTypeName() {
        return materialTypeName;
    }

    public String getDescription() {
        return description;
    }

    public String getParentMaterialTypeId() {
        return parentMaterialTypeId;
    }

    public void setMaterialTypeNo(String materialTypeNo) {
        this.materialTypeNo = materialTypeNo;
    }

    public void setMaterialTypeName(String materialTypeName) {
        this.materialTypeName = materialTypeName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setParentMaterialTypeId(String parentMaterialTypeId) {
        this.parentMaterialTypeId = parentMaterialTypeId;
    }
}
