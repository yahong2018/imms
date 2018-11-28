package com.zhxh.imms.code.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.CheckUnique;

public class Uom implements EntityObject {
    private String rowId;

    @CheckUnique
    private String uomNo;

    private String uomName;
    private String description;

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getUomNo() {
        return uomNo;
    }

    public String getUomName() {
        return uomName;
    }

    public String getDescription() {
        return description;
    }

    public void setUomNo(String uomNo) {
        this.uomNo = uomNo;
    }

    public void setUomName(String uomName) {
        this.uomName = uomName;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
