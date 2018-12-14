package com.zhxh.imms.factory.vo;

import com.zhxh.imms.factory.entity.WorkCenter;

public class WorkCenterVO extends WorkCenter {
    private String plantName;
    private String plantNo;

    public String getPlantNo() {
        return plantNo;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantNo(String plantNo) {
        this.plantNo = plantNo;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }
}
