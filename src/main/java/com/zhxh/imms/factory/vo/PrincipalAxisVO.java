package com.zhxh.imms.factory.vo;

import com.zhxh.imms.factory.entity.PrincipalAxis;

public class PrincipalAxisVO extends PrincipalAxis {
    private String workCenterNo;
    private String workCenterName;

    public String getWorkCenterNo() {
        return workCenterNo;
    }

    public String getWorkCenterName() {
        return workCenterName;
    }

    public void setWorkCenterNo(String workCenterNo) {
        this.workCenterNo = workCenterNo;
    }

    public void setWorkCenterName(String workCenterName) {
        this.workCenterName = workCenterName;
    }
}
