package com.zhxh.imms.material.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.AutoGeneration;

public class MaterialMedia implements EntityObject {
    @AutoGeneration
    private String materialMediaId;

    private String materialMediaMediaId;
    private String materialMediaMaterialId;

    public String getMaterialMediaId() {
        return materialMediaId;
    }

    public String getMaterialMediaMaterialId() {
        return materialMediaMaterialId;
    }


    public String getMaterialMediaMediaId() {
        return materialMediaMediaId;
    }

    public void setMaterialMediaId(String materialMediaId) {
        this.materialMediaId = materialMediaId;
    }

    public void setMaterialMediaMaterialId(String materialMediaMaterialId) {
        this.materialMediaMaterialId = materialMediaMaterialId;
    }

    public void setMaterialMediaMediaId(String materialMediaMediaId) {
        this.materialMediaMediaId = materialMediaMediaId;
    }
}
