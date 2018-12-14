package com.zhxh.imms.factory.entity;

import com.zhxh.core.data.EntityObject;

public class WorkCenter implements EntityObject {
    private String workCenterId;
    private String workCenterNo;
    private String workCenterName;
    private String workCenterDescription;
    private String workCenterPlantId;

    public String getWorkCenterId() {
        return workCenterId;
    }

    public String getWorkCenterNo() {
        return workCenterNo;
    }

    public String getWorkCenterName() {
        return workCenterName;
    }

    public String getWorkCenterDescription() {
        return workCenterDescription;
    }

    public String getWorkCenterPlantId() {
        return workCenterPlantId;
    }

    public void setWorkCenterId(String workCenterId) {
        this.workCenterId = workCenterId;
    }

    public void setWorkCenterNo(String workCenterNo) {
        this.workCenterNo = workCenterNo;
    }

    public void setWorkCenterName(String workCenterName) {
        this.workCenterName = workCenterName;
    }

    public void setWorkCenterDescription(String workCenterDescription) {
        this.workCenterDescription = workCenterDescription;
    }

    public void setWorkCenterPlantId(String workCenterPlantId) {
        this.workCenterPlantId = workCenterPlantId;
    }
}
