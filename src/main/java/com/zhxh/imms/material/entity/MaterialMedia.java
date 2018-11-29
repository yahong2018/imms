package com.zhxh.imms.material.entity;

import com.zhxh.core.data.EntityObject;

public class MaterialMedia implements EntityObject {
    private String rowId;
    private String mediaId;
    private String materialId;


    public String getRowId() {
        return rowId;
    }

    public String getMediaId() {
        return mediaId;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
