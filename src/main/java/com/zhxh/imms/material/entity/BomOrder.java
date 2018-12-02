package com.zhxh.imms.material.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.AutoGeneration;
import com.zhxh.core.data.meta.annotation.CheckUnique;

public class BomOrder implements EntityObject {
    @AutoGeneration
    private String bomOrderId;

    @CheckUnique
    private String bomOrderNo;
    private String bomType;

    public String getBomOrderNo() {
        return bomOrderNo;
    }


    public void setBomOrderNo(String bomOrderNo) {
        this.bomOrderNo = bomOrderNo;
    }
}
