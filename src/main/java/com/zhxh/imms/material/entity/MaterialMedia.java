package com.zhxh.imms.material.entity;

import com.zhxh.core.data.EntityObject;

public class MaterialMedia implements EntityObject {
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
}
