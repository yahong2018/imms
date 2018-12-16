package com.zhxh.imms.mes.ro.entity;

import com.zhxh.core.data.EntityObject;

import java.time.LocalDateTime;

public class RequirementOrder implements EntityObject {
    private String requirementOrderId;
    private String requirementOrderNo;
    private String requirementOrderType;
    private String requirementOrderStatus;
    private String requirementOrderPriority;
    private String requirementOrderPlantId;
    private String requirementOrderWorkCenterId;
    private String requirementOrderFgMaterialId;
    private int requirementOrderPlannedQty;
    private LocalDateTime requirementOrderRequiredDeliveryDate;
    private String requirementOrderSaleOrderNo;
    private String requirementOrderRepeatType;

    public int getRequirementOrderPlannedQty() {
        return requirementOrderPlannedQty;
    }

    public LocalDateTime getRequirementOrderRequiredDeliveryDate() {
        return requirementOrderRequiredDeliveryDate;
    }

    public String getRequirementOrderFgMaterialId() {
        return requirementOrderFgMaterialId;
    }

    public String getRequirementOrderId() {
        return requirementOrderId;
    }

    public String getRequirementOrderNo() {
        return requirementOrderNo;
    }

    public String getRequirementOrderPlantId() {
        return requirementOrderPlantId;
    }

    public String getRequirementOrderPriority() {
        return requirementOrderPriority;
    }

    public String getRequirementOrderRepeatType() {
        return requirementOrderRepeatType;
    }

    public String getRequirementOrderSaleOrderNo() {
        return requirementOrderSaleOrderNo;
    }

    public String getRequirementOrderStatus() {
        return requirementOrderStatus;
    }

    public String getRequirementOrderType() {
        return requirementOrderType;
    }

    public String getRequirementOrderWorkCenterId() {
        return requirementOrderWorkCenterId;
    }

    public void setRequirementOrderFgMaterialId(String requirementOrderFgMaterialId) {
        this.requirementOrderFgMaterialId = requirementOrderFgMaterialId;
    }

    public void setRequirementOrderId(String requirementOrderId) {
        this.requirementOrderId = requirementOrderId;
    }

    public void setRequirementOrderNo(String requirementOrderNo) {
        this.requirementOrderNo = requirementOrderNo;
    }

    public void setRequirementOrderPlannedQty(int requirementOrderPlannedQty) {
        this.requirementOrderPlannedQty = requirementOrderPlannedQty;
    }

    public void setRequirementOrderPlantId(String requirementOrderPlantId) {
        this.requirementOrderPlantId = requirementOrderPlantId;
    }

    public void setRequirementOrderPriority(String requirementOrderPriority) {
        this.requirementOrderPriority = requirementOrderPriority;
    }

    public void setRequirementOrderRepeatType(String requirementOrderRepeatType) {
        this.requirementOrderRepeatType = requirementOrderRepeatType;
    }

    public void setRequirementOrderRequiredDeliveryDate(LocalDateTime requirementOrderRequiredDeliveryDate) {
        this.requirementOrderRequiredDeliveryDate = requirementOrderRequiredDeliveryDate;
    }

    public void setRequirementOrderSaleOrderNo(String requirementOrderSaleOrderNo) {
        this.requirementOrderSaleOrderNo = requirementOrderSaleOrderNo;
    }

    public void setRequirementOrderStatus(String requirementOrderStatus) {
        this.requirementOrderStatus = requirementOrderStatus;
    }

    public void setRequirementOrderType(String requirementOrderType) {
        this.requirementOrderType = requirementOrderType;
    }

    public void setRequirementOrderWorkCenterId(String requirementOrderWorkCenterId) {
        this.requirementOrderWorkCenterId = requirementOrderWorkCenterId;
    }
}
