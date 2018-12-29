package com.zhxh.imms.factory.entity;

import com.zhxh.core.data.EntityObject;

public class WorkStation extends EntityObject {
    private String workStationId;
    private String workStationNo;
    private String workStationPlantId;
    private String workStationDescription;
    private String workStationWorkType;
    private String workStationType;
    private String workStationStatus;
    private String workStationDirection;
    private String workStationIpAddress;
    private int workStationMaxWipQty;
    private int workStationCurrentWipQty;
    private String workStationWorkCenterId;
    private String workStationRemoteFileAddress;

    public int getWorkStationCurrentWipQty() {
        return workStationCurrentWipQty;
    }

    public String getWorkStationDescription() {
        return workStationDescription;
    }

    public int getWorkStationMaxWipQty() {
        return workStationMaxWipQty;
    }

    public String getWorkStationDirection() {
        return workStationDirection;
    }

    public String getWorkStationId() {
        return workStationId;
    }

    public String getWorkStationIpAddress() {
        return workStationIpAddress;
    }

    public String getWorkStationNo() {
        return workStationNo;
    }

    public String getWorkStationPlantId() {
        return workStationPlantId;
    }

    public String getWorkStationRemoteFileAddress() {
        return workStationRemoteFileAddress;
    }

    public String getWorkStationStatus() {
        return workStationStatus;
    }

    public String getWorkStationType() {
        return workStationType;
    }

    public String getWorkStationWorkCenterId() {
        return workStationWorkCenterId;
    }

    public String getWorkStationWorkType() {
        return workStationWorkType;
    }

    public void setWorkStationId(String workStationId) {
        this.workStationId = workStationId;
    }

    public void setWorkStationCurrentWipQty(int workStationCurrentWipQty) {
        this.workStationCurrentWipQty = workStationCurrentWipQty;
    }

    public void setWorkStationDescription(String workStationDescription) {
        this.workStationDescription = workStationDescription;
    }

    public void setWorkStationDirection(String workStationDirection) {
        this.workStationDirection = workStationDirection;
    }

    public void setWorkStationIpAddress(String workStationIpAddress) {
        this.workStationIpAddress = workStationIpAddress;
    }

    public void setWorkStationMaxWipQty(int workStationMaxWipQty) {
        this.workStationMaxWipQty = workStationMaxWipQty;
    }

    public void setWorkStationNo(String workStationNo) {
        this.workStationNo = workStationNo;
    }

    public void setWorkStationPlantId(String workStationPlantId) {
        this.workStationPlantId = workStationPlantId;
    }

    public void setWorkStationRemoteFileAddress(String workStationRemoteFileAddress) {
        this.workStationRemoteFileAddress = workStationRemoteFileAddress;
    }

    public void setWorkStationStatus(String workStationStatus) {
        this.workStationStatus = workStationStatus;
    }

    public void setWorkStationType(String workStationType) {
        this.workStationType = workStationType;
    }

    public void setWorkStationWorkCenterId(String workStationWorkCenterId) {
        this.workStationWorkCenterId = workStationWorkCenterId;
    }

    public void setWorkStationWorkType(String workStationWorkType) {
        this.workStationWorkType = workStationWorkType;
    }
}
