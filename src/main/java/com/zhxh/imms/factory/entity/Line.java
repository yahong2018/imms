package com.zhxh.imms.factory.entity;

import com.zhxh.core.data.EntityObject;

public class Line extends EntityObject {
    private String lineId;
    private String lineWorkCenterId;
    private int lineSequenceNumber;
    private String lineStartMainLineId;
    private String lineEndMainLineId;
    private double lineLength;
    private double lineWidth;
    private String lineRotatingDirection;
    private double lineSpeed;
    private double linePreLinesSpacing;
    private double lineLeftDistance;
    private String lineProductionLineCode;

    public String getLineId() {
        return lineId;
    }

    public String getLineEndMainLineId() {
        return lineEndMainLineId;
    }

    public String getLineProductionLineCode() {
        return lineProductionLineCode;
    }

    public String getLineRotatingDirection() {
        return lineRotatingDirection;
    }

    public String getLineWorkCenterId() {
        return lineWorkCenterId;
    }

    public String getLineStartMainLineId() {
        return lineStartMainLineId;
    }

    public double getLineLeftDistance() {
        return lineLeftDistance;
    }

    public double getLineLength() {
        return lineLength;
    }


    public double getLineSpeed() {
        return lineSpeed;
    }

    public double getLinePreLinesSpacing() {
        return linePreLinesSpacing;
    }

    public int getLineSequenceNumber() {
        return lineSequenceNumber;
    }

    public double getLineWidth() {
        return lineWidth;
    }

    public void setLineEndMainLineId(String lineEndMainLineId) {
        this.lineEndMainLineId = lineEndMainLineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public void setLineLeftDistance(double lineLeftDistance) {
        this.lineLeftDistance = lineLeftDistance;
    }

    public void setLineLength(double lineLength) {
        this.lineLength = lineLength;
    }

    public void setLinePreLinesSpacing(double linePreLinesSpacing) {
        this.linePreLinesSpacing = linePreLinesSpacing;
    }

    public void setLineProductionLineCode(String lineProductionLineCode) {
        this.lineProductionLineCode = lineProductionLineCode;
    }

    public void setLineRotatingDirection(String lineRotatingDirection) {
        this.lineRotatingDirection = lineRotatingDirection;
    }

    public void setLineSequenceNumber(int lineSequenceNumber) {
        this.lineSequenceNumber = lineSequenceNumber;
    }

    public void setLineSpeed(double lineSpeed) {
        this.lineSpeed = lineSpeed;
    }

    public void setLineStartMainLineId(String lineStartMainLineId) {
        this.lineStartMainLineId = lineStartMainLineId;
    }

    public void setLineWidth(double lineWidth) {
        this.lineWidth = lineWidth;
    }

    public void setLineWorkCenterId(String lineWorkCenterId) {
        this.lineWorkCenterId = lineWorkCenterId;
    }
}
