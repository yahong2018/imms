package com.zhxh.imms.factory.vo;

import com.zhxh.imms.factory.entity.WorkStation;

public class WorkStationVO extends WorkStation {
    private String plantName;
    private String plantNo;
    private String workCenterNo;

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

    public String getWorkCenterNo() {
        return workCenterNo;
    }

    public void setWorkCenterNo(String workCenterNo) {
        this.workCenterNo = workCenterNo;
    }
}
