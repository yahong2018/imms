package com.zhxh.imms.material.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.CheckUnique;

public class BomOrder implements EntityObject {
    private String rowId;

    @CheckUnique
    private String bomOrderNo;
    private String type;

    public String getRowId() {
        return rowId;
    }

    public String getBomOrderNo() {
        return bomOrderNo;
    }

    public String getType() {
        return type;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBomOrderNo(String bomOrderNo) {
        this.bomOrderNo = bomOrderNo;
    }
}
