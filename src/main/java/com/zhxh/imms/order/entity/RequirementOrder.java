package com.zhxh.imms.order.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.imms.material.vo.BomVO;

import java.time.LocalDateTime;

public class RequirementOrder extends EntityObject {
    public static final String REPEAT_TYPE_FIRST="F";
    public static final String REPEAT_TYPE_REPEAT="R";
    public static final String REPEAT_TYPE_SUPPLEMENT="S";

    private String requirementOrderId;
    private String requirementOrderNo;
    private OrderType requirementOrderType;
    private String requirementOrderStatus;
    private String requirementOrderPriority;
    private String requirementOrderPlantId;
    private String requirementOrderWorkCenterId;
    private String requirementOrderFgMaterialId;
    private int requirementOrderPlannedQty;
    private LocalDateTime requirementOrderRequiredDeliveryDate;
    private String requirementOrderSaleOrderNo;
    private String requirementOrderRepeatType;
    private String requirementOrderSource;

    private ProductionOrderSize[] orderSizes;
    private BomVO[] boms;

    public BomVO[] getBoms() {
        return boms;
    }

    public void setBoms(BomVO[] boms) {
        this.boms = boms;
    }

    public ProductionOrderSize[] getOrderSizes() {
        return orderSizes;
    }

    public void setOrderSizes(ProductionOrderSize[] orderSizes) {
        this.orderSizes = orderSizes;
    }

    public String getRequirementOrderSource() {
        return requirementOrderSource;
    }

    public void setRequirementOrderSource(String requirementOrderSource) {
        this.requirementOrderSource = requirementOrderSource;
    }

    public boolean isFirstOrder(){
        return REPEAT_TYPE_FIRST.equalsIgnoreCase(this.requirementOrderRepeatType);
    }

    public boolean isRepeatOrder(){
        return REPEAT_TYPE_REPEAT.equalsIgnoreCase(this.requirementOrderRepeatType);
    }

    public boolean isSupplementOrder(){
        return REPEAT_TYPE_SUPPLEMENT.equalsIgnoreCase(this.requirementOrderRepeatType);
    }

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

    public OrderType getRequirementOrderType() {
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

    public void setRequirementOrderType(OrderType requirementOrderType) {
        this.requirementOrderType = requirementOrderType;
    }

    public void setRequirementOrderWorkCenterId(String requirementOrderWorkCenterId) {
        this.requirementOrderWorkCenterId = requirementOrderWorkCenterId;
    }
}
