package com.zhxh.imms.code.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.AutoGeneration;
import com.zhxh.core.data.meta.annotation.CheckUnique;

import java.util.UUID;

public class Uom extends EntityObject {
    @AutoGeneration
    private String uomId;

    @CheckUnique
    private String uomNo;

    private String uomName;
    private String uomDescription;

    public String getUomId() {
        return uomId;
    }

    public void setUomId(String uomId) {
        this.uomId = uomId;
    }

    public String getUomNo() {
        return uomNo;
    }

    public String getUomName() {
        return uomName;
    }

    public void setUomNo(String uomNo) {
        this.uomNo = uomNo;
    }

    public void setUomName(String uomName) {
        this.uomName = uomName;
    }

    public String getUomDescription() {
        return uomDescription;
    }

    public void setUomDescription(String uomDescription) {
        this.uomDescription = uomDescription;
    }
}
