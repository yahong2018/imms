package com.zhxh.imms.code.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.CheckUnique;
import com.zhxh.core.data.meta.annotation.TreeTable;
import com.zhxh.core.data.meta.annotation.TreeTableParentKey;

import java.util.UUID;

@TreeTable
public class MaterialType implements EntityObject {
    private String materialTypeId;

    @CheckUnique
    private String materialTypeNo;
    private String materialTypeName;
    private String materialTypeDescription;

    @TreeTableParentKey
    private String parentMaterialTypeId;

    public MaterialType(){
        this.materialTypeId = UUID.randomUUID().toString();
    }


    public String getMaterialTypeId() {
        return materialTypeId;
    }

    public void setMaterialTypeId(String materialTypeId) {
        this.materialTypeId = materialTypeId;
    }

    public String getMaterialTypeNo() {
        return materialTypeNo;
    }

    public String getMaterialTypeName() {
        return materialTypeName;
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

    public void setParentMaterialTypeId(String parentMaterialTypeId) {
        this.parentMaterialTypeId = parentMaterialTypeId;
    }

    public String getMaterialTypeDescription() {
        return materialTypeDescription;
    }

    public void setMaterialTypeDescription(String materialTypeDescription) {
        this.materialTypeDescription = materialTypeDescription;
    }
}
