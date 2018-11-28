package com.zhxh.imms.code.entity;

import com.zhxh.core.data.EntityObject;

public class Uom implements EntityObject {
    private long id;
    private String uomNo;
    private String uomName;
    private String description;

    public long getId() {
        return id;
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

    public void setId(long id) {
        this.id = id;
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
