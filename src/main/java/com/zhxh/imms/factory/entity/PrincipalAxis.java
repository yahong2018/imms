package com.zhxh.imms.factory.entity;

import com.zhxh.core.data.EntityObject;

public class PrincipalAxis implements EntityObject {
    private String principalAxisId;
    private String principalAxisNo;
    private int principalAxisSequenceNumber;
    private String principalAxisRotatingDirection;
    private double principalAxisLength;
    private double principalAxisWidth;
    private double principalAxisSpeed;
    private String principalAxisWorkCenterId;

    public double getPrincipalAxisLength() {
        return principalAxisLength;
    }

    public double getPrincipalAxisSpeed() {
        return principalAxisSpeed;
    }

    public double getPrincipalAxisWidth() {
        return principalAxisWidth;
    }

    public int getPrincipalAxisSequenceNumber() {
        return principalAxisSequenceNumber;
    }

    public String getPrincipalAxisId() {
        return principalAxisId;
    }

    public String getPrincipalAxisNo() {
        return principalAxisNo;
    }

    public String getPrincipalAxisRotatingDirection() {
        return principalAxisRotatingDirection;
    }

    public String getPrincipalAxisWorkCenterId() {
        return principalAxisWorkCenterId;
    }

    public void setPrincipalAxisId(String principalAxisId) {
        this.principalAxisId = principalAxisId;
    }

    public void setPrincipalAxisLength(double principalAxisLength) {
        this.principalAxisLength = principalAxisLength;
    }

    public void setPrincipalAxisNo(String principalAxisNo) {
        this.principalAxisNo = principalAxisNo;
    }

    public void setPrincipalAxisRotatingDirection(String principalAxisRotatingDirection) {
        this.principalAxisRotatingDirection = principalAxisRotatingDirection;
    }

    public void setPrincipalAxisSequenceNumber(int principalAxisSequenceNumber) {
        this.principalAxisSequenceNumber = principalAxisSequenceNumber;
    }

    public void setPrincipalAxisSpeed(double principalAxisSpeed) {
        this.principalAxisSpeed = principalAxisSpeed;
    }

    public void setPrincipalAxisWidth(double principalAxisWidth) {
        this.principalAxisWidth = principalAxisWidth;
    }

    public void setPrincipalAxisWorkCenterId(String principalAxisWorkCenterId) {
        this.principalAxisWorkCenterId = principalAxisWorkCenterId;
    }
}
