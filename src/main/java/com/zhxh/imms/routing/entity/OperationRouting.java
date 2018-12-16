package com.zhxh.imms.routing.entity;

import com.zhxh.core.data.EntityObject;

import java.time.LocalDateTime;

public class OperationRouting implements EntityObject {
    private String        operationRoutingId;
    private String        operationRoutingOperationId;
    private String        operationRoutingOrderId;
    private String        operationRoutingQaProcedure;
    private float         operationRoutingStandardPrice;
    private String        operationRoutingSectionType;
    private String        operationRoutingMachineTypeId;
    private String        operationRoutingActualStationId;
    private String        operationRoutingOperatorId;
    private float         operationRoutingStandardTime;
    private float         operationRoutingActualTime;
    private String        operationRoutingPreOperationId;
    private String        operationRoutingSopFilePath;
    private String        operationRoutingStatus;
    private String        operationRoutingRequiredLevel;
    private int           operationRoutingScrapQty;
    private int           operationRoutingCompleteQty;
    private String        operationRoutingPreRoutingId;
    private int           operationRoutingSequenceNo;
    private String        operationRoutingPartType;
    private String        operationRoutingIfOutsource;
    private LocalDateTime operationRoutingPullInTime;
    private LocalDateTime operationRoutingPullOutTime;

    public int getOperationRoutingSequenceNo() {
        return operationRoutingSequenceNo;
    }

    public void setOperationRoutingSequenceNo(int operationRoutingSequenceNo) {
        this.operationRoutingSequenceNo = operationRoutingSequenceNo;
    }

    public String getOperationRoutingId() {
        return operationRoutingId;
    }

    public void setOperationRoutingId(String operationRoutingId) {
        this.operationRoutingId = operationRoutingId;
    }

    public String getOperationRoutingOperationId() {
        return operationRoutingOperationId;
    }

    public void setOperationRoutingOperationId(String operationRoutingOperationId) {
        this.operationRoutingOperationId = operationRoutingOperationId;
    }

    public String getOperationRoutingOrderId() {
        return operationRoutingOrderId;
    }

    public void setOperationRoutingOrderId(String operationRoutingOrderId) {
        this.operationRoutingOrderId = operationRoutingOrderId;
    }

    public String getOperationRoutingQaProcedure() {
        return operationRoutingQaProcedure;
    }

    public void setOperationRoutingQaProcedure(String operationRoutingQaProcedure) {
        this.operationRoutingQaProcedure = operationRoutingQaProcedure;
    }

    public float getOperationRoutingStandardPrice() {
        return operationRoutingStandardPrice;
    }

    public void setOperationRoutingStandardPrice(float operationRoutingStandardPrice) {
        this.operationRoutingStandardPrice = operationRoutingStandardPrice;
    }

    public String getOperationRoutingSectionType() {
        return operationRoutingSectionType;
    }

    public void setOperationRoutingSectionType(String operationRoutingSectionType) {
        this.operationRoutingSectionType = operationRoutingSectionType;
    }

    public String getOperationRoutingMachineTypeId() {
        return operationRoutingMachineTypeId;
    }

    public void setOperationRoutingMachineTypeId(String operationRoutingMachineTypeId) {
        this.operationRoutingMachineTypeId = operationRoutingMachineTypeId;
    }

    public String getOperationRoutingActualStationId() {
        return operationRoutingActualStationId;
    }

    public void setOperationRoutingActualStationId(String operationRoutingActualStationId) {
        this.operationRoutingActualStationId = operationRoutingActualStationId;
    }

    public String getOperationRoutingOperatorId() {
        return operationRoutingOperatorId;
    }

    public void setOperationRoutingOperatorId(String operationRoutingOperatorId) {
        this.operationRoutingOperatorId = operationRoutingOperatorId;
    }

    public float getOperationRoutingStandardTime() {
        return operationRoutingStandardTime;
    }

    public void setOperationRoutingStandardTime(float operationRoutingStandardTime) {
        this.operationRoutingStandardTime = operationRoutingStandardTime;
    }

    public float getOperationRoutingActualTime() {
        return operationRoutingActualTime;
    }

    public void setOperationRoutingActualTime(float operationRoutingActualTime) {
        this.operationRoutingActualTime = operationRoutingActualTime;
    }

    public String getOperationRoutingPreOperationId() {
        return operationRoutingPreOperationId;
    }

    public void setOperationRoutingPreOperationId(String operationRoutingPreOperationId) {
        this.operationRoutingPreOperationId = operationRoutingPreOperationId;
    }

    public String getOperationRoutingSopFilePath() {
        return operationRoutingSopFilePath;
    }

    public void setOperationRoutingSopFilePath(String operationRoutingSopFilePath) {
        this.operationRoutingSopFilePath = operationRoutingSopFilePath;
    }

    public String getOperationRoutingStatus() {
        return operationRoutingStatus;
    }

    public void setOperationRoutingStatus(String operationRoutingStatus) {
        this.operationRoutingStatus = operationRoutingStatus;
    }

    public String getOperationRoutingRequiredLevel() {
        return operationRoutingRequiredLevel;
    }

    public void setOperationRoutingRequiredLevel(String operationRoutingRequiredLevel) {
        this.operationRoutingRequiredLevel = operationRoutingRequiredLevel;
    }

    public int getOperationRoutingScrapQty() {
        return operationRoutingScrapQty;
    }

    public void setOperationRoutingScrapQty(int operationRoutingScrapQty) {
        this.operationRoutingScrapQty = operationRoutingScrapQty;
    }

    public int getOperationRoutingCompleteQty() {
        return operationRoutingCompleteQty;
    }

    public void setOperationRoutingCompleteQty(int operationRoutingCompleteQty) {
        this.operationRoutingCompleteQty = operationRoutingCompleteQty;
    }

    public String getOperationRoutingPreRoutingId() {
        return operationRoutingPreRoutingId;
    }

    public void setOperationRoutingPreRoutingId(String operationRoutingPreRoutingId) {
        this.operationRoutingPreRoutingId = operationRoutingPreRoutingId;
    }

    public String getOperationRoutingPartType() {
        return operationRoutingPartType;
    }

    public void setOperationRoutingPartType(String operationRoutingPartType) {
        this.operationRoutingPartType = operationRoutingPartType;
    }

    public String getOperationRoutingIfOutsource() {
        return operationRoutingIfOutsource;
    }

    public void setOperationRoutingIfOutsource(String operationRoutingIfOutsource) {
        this.operationRoutingIfOutsource = operationRoutingIfOutsource;
    }

    public LocalDateTime getOperationRoutingPullInTime() {
        return operationRoutingPullInTime;
    }

    public void setOperationRoutingPullInTime(LocalDateTime operationRoutingPullInTime) {
        this.operationRoutingPullInTime = operationRoutingPullInTime;
    }

    public LocalDateTime getOperationRoutingPullOutTime() {
        return operationRoutingPullOutTime;
    }

    public void setOperationRoutingPullOutTime(LocalDateTime operationRoutingPullOutTime) {
        this.operationRoutingPullOutTime = operationRoutingPullOutTime;
    }
}
