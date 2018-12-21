package com.zhxh.imms.order.vo;

import com.zhxh.imms.order.entity.RequirementOrder;

public class RequirementOrderVO extends RequirementOrder {
    private String materialNo;
    private String materialName;
    private String workCenterNo;
    private String workCenterName;

    public String getMaterialNo() {
        return materialNo;
    }

    public void setMaterialNo(String materialNo) {
        this.materialNo = materialNo;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getWorkCenterNo() {
        return workCenterNo;
    }

    public void setWorkCenterNo(String workCenterNo) {
        this.workCenterNo = workCenterNo;
    }

    public String getWorkCenterName() {
        return workCenterName;
    }

    public void setWorkCenterName(String workCenterName) {
        this.workCenterName = workCenterName;
    }



}
