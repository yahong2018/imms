package com.zhxh.imms.order.entity;

import com.zhxh.core.data.TraceableEntity;

import java.time.LocalDateTime;

public class ScheduleOrder extends TraceableEntity {
    public String getScheduleOrderStatus() {
        return scheduleOrderStatus;
    }

    public void setScheduleOrderStatus(String scheduleOrderStatus) {
        this.scheduleOrderStatus = scheduleOrderStatus;
    }

    public String getScheduleOrderCode() {
        return scheduleOrderCode;
    }

    public void setScheduleOrderCode(String scheduleOrderCode) {
        this.scheduleOrderCode = scheduleOrderCode;
    }

    public String getScheduleOrderPlant() {
        return scheduleOrderPlant;
    }

    public void setScheduleOrderPlant(String scheduleOrderPlant) {
        this.scheduleOrderPlant = scheduleOrderPlant;
    }

    public String getScheduleOrderWorkCenter() {
        return scheduleOrderWorkCenter;
    }

    public void setScheduleOrderWorkCenter(String scheduleOrderWorkCenter) {
        this.scheduleOrderWorkCenter = scheduleOrderWorkCenter;
    }

    public String getScheduleOrderFgMaterial() {
        return scheduleOrderFgMaterial;
    }

    public void setScheduleOrderFgMaterial(String scheduleOrderFgMaterial) {
        this.scheduleOrderFgMaterial = scheduleOrderFgMaterial;
    }

    public int getScheduleOrderPlannedQty() {
        return scheduleOrderPlannedQty;
    }

    public void setScheduleOrderPlannedQty(int scheduleOrderPlannedQty) {
        this.scheduleOrderPlannedQty = scheduleOrderPlannedQty;
    }

    public String getScheduleOrderProductionOrderCode() {
        return scheduleOrderProductionOrderCode;
    }

    public void setScheduleOrderProductionOrderCode(String scheduleOrderProductionOrderCode) {
        this.scheduleOrderProductionOrderCode = scheduleOrderProductionOrderCode;
    }

    public LocalDateTime getScheduleOrderRequiredDeliveryDate() {
        return scheduleOrderRequiredDeliveryDate;
    }

    public void setScheduleOrderRequiredDeliveryDate(LocalDateTime scheduleOrderRequiredDeliveryDate) {
        this.scheduleOrderRequiredDeliveryDate = scheduleOrderRequiredDeliveryDate;
    }

    public LocalDateTime getScheduleOrderPlannedStartDate() {
        return scheduleOrderPlannedStartDate;
    }

    public void setScheduleOrderPlannedStartDate(LocalDateTime scheduleOrderPlannedStartDate) {
        this.scheduleOrderPlannedStartDate = scheduleOrderPlannedStartDate;
    }

    public LocalDateTime getScheduleOrderPlannedEndDate() {
        return scheduleOrderPlannedEndDate;
    }

    public void setScheduleOrderPlannedEndDate(LocalDateTime scheduleOrderPlannedEndDate) {
        this.scheduleOrderPlannedEndDate = scheduleOrderPlannedEndDate;
    }

    public LocalDateTime getScheduleOrderActualStartDate() {
        return scheduleOrderActualStartDate;
    }

    public void setScheduleOrderActualStartDate(LocalDateTime scheduleOrderActualStartDate) {
        this.scheduleOrderActualStartDate = scheduleOrderActualStartDate;
    }

    public LocalDateTime getScheduleOrderActualEndDate() {
        return scheduleOrderActualEndDate;
    }

    public void setScheduleOrderActualEndDate(LocalDateTime scheduleOrderActualEndDate) {
        this.scheduleOrderActualEndDate = scheduleOrderActualEndDate;
    }

    private String scheduleOrderStatus;
    private String scheduleOrderCode;
    private String scheduleOrderPlant;
    private String scheduleOrderWorkCenter;
    private String scheduleOrderFgMaterial;
    private int scheduleOrderPlannedQty;
    private String scheduleOrderProductionOrderCode;
    private LocalDateTime scheduleOrderRequiredDeliveryDate;
    private LocalDateTime scheduleOrderPlannedStartDate;
    private LocalDateTime scheduleOrderPlannedEndDate;
    private LocalDateTime scheduleOrderActualStartDate;
    private LocalDateTime scheduleOrderActualEndDate;

}
