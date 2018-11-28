package com.zhxh.imms.code.entity;

import com.zhxh.core.data.EntityObject;

public class MaterialType implements EntityObject {
    private long id;
    private String materialTypeNo;
    private String materialTypeName;
    private String description;
    private long parentMaterialTypeId;

    public long getId() {
        return id;
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

    public long getParentMaterialTypeId() {
        return parentMaterialTypeId;
    }

    public void setId(long id) {
        this.id = id;
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

    public void setParentMaterialTypeId(long parentMaterialTypeId) {
        this.parentMaterialTypeId = parentMaterialTypeId;
    }
}
