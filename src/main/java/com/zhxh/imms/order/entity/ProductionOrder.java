package com.zhxh.imms.order.entity;

import com.zhxh.core.data.TraceableEntity;

import java.time.LocalDateTime;

public class ProductionOrder extends TraceableEntity {
    private String  productionOrderId;
    private String  productionOrderNo;
    private String  productionOrderType;
    private String  productionOrderBomOrderId;
    private String  productionOrderOperationRoutingOrderId;
    private String  productionOrderSource;
    private String  productionOrderMaterialReady;
    private String  productionOrderStatus;
    private String  productionOrderPriority;
    private String  productionOrderRequirementOrderId;
    private String  productionOrderPlantId;
    private String  productionOrderWorkCenterId;
    private String  productionOrderFgMaterialId;
    private int  productionOrderPlannedQty;
    private int  productionOrderFinishedQty;
    private int  productionOrderSecondQualityQty;
    private int  productionOrderDefectQty;
    private int  productionOrderActualQty;
    private LocalDateTime productionOrderRequiredDeliveryDate;
    private LocalDateTime  productionOrderPlannedStartDate;
    private LocalDateTime  productionOrderPlannedEndDate;
    private LocalDateTime  productionOrderActualStartDate;
    private LocalDateTime  productionOrderActualEndDate;
    private String  productionOrderScheduleOrderId;

    public String getProductionOrderId() {
        return productionOrderId;
    }

    public void setProductionOrderId(String productionOrderId) {
        this.productionOrderId = productionOrderId;
    }

    public String getProductionOrderNo() {
        return productionOrderNo;
    }

    public void setProductionOrderNo(String productionOrderNo) {
        this.productionOrderNo = productionOrderNo;
    }

    public String getProductionOrderType() {
        return productionOrderType;
    }

    public void setProductionOrderType(String productionOrderType) {
        this.productionOrderType = productionOrderType;
    }

    public String getProductionOrderBomOrderId() {
        return productionOrderBomOrderId;
    }

    public void setProductionOrderBomOrderId(String productionOrderBomOrderId) {
        this.productionOrderBomOrderId = productionOrderBomOrderId;
    }

    public String getProductionOrderOperationRoutingOrderId() {
        return productionOrderOperationRoutingOrderId;
    }

    public void setProductionOrderOperationRoutingOrderId(String productionOrderOperationRoutingOrderId) {
        this.productionOrderOperationRoutingOrderId = productionOrderOperationRoutingOrderId;
    }

    public String getProductionOrderSource() {
        return productionOrderSource;
    }

    public void setProductionOrderSource(String productionOrderSource) {
        this.productionOrderSource = productionOrderSource;
    }

    public String getProductionOrderMaterialReady() {
        return productionOrderMaterialReady;
    }

    public void setProductionOrderMaterialReady(String productionOrderMaterialReady) {
        this.productionOrderMaterialReady = productionOrderMaterialReady;
    }

    public String getProductionOrderStatus() {
        return productionOrderStatus;
    }

    public void setProductionOrderStatus(String productionOrderStatus) {
        this.productionOrderStatus = productionOrderStatus;
    }

    public String getProductionOrderPriority() {
        return productionOrderPriority;
    }

    public void setProductionOrderPriority(String productionOrderPriority) {
        this.productionOrderPriority = productionOrderPriority;
    }

    public String getProductionOrderRequirementOrderId() {
        return productionOrderRequirementOrderId;
    }

    public void setProductionOrderRequirementOrderId(String productionOrderRequirementOrderId) {
        this.productionOrderRequirementOrderId = productionOrderRequirementOrderId;
    }

    public String getProductionOrderPlantId() {
        return productionOrderPlantId;
    }

    public void setProductionOrderPlantId(String productionOrderPlantId) {
        this.productionOrderPlantId = productionOrderPlantId;
    }

    public String getProductionOrderWorkCenterId() {
        return productionOrderWorkCenterId;
    }

    public void setProductionOrderWorkCenterId(String productionOrderWorkCenterId) {
        this.productionOrderWorkCenterId = productionOrderWorkCenterId;
    }

    public String getProductionOrderFgMaterialId() {
        return productionOrderFgMaterialId;
    }

    public void setProductionOrderFgMaterialId(String productionOrderFgMaterialId) {
        this.productionOrderFgMaterialId = productionOrderFgMaterialId;
    }

    public int getProductionOrderPlannedQty() {
        return productionOrderPlannedQty;
    }

    public void setProductionOrderPlannedQty(int productionOrderPlannedQty) {
        this.productionOrderPlannedQty = productionOrderPlannedQty;
    }

    public int getProductionOrderFinishedQty() {
        return productionOrderFinishedQty;
    }

    public void setProductionOrderFinishedQty(int productionOrderFinishedQty) {
        this.productionOrderFinishedQty = productionOrderFinishedQty;
    }

    public int getProductionOrderSecondQualityQty() {
        return productionOrderSecondQualityQty;
    }

    public void setProductionOrderSecondQualityQty(int productionOrderSecondQualityQty) {
        this.productionOrderSecondQualityQty = productionOrderSecondQualityQty;
    }

    public int getProductionOrderDefectQty() {
        return productionOrderDefectQty;
    }

    public void setProductionOrderDefectQty(int productionOrderDefectQty) {
        this.productionOrderDefectQty = productionOrderDefectQty;
    }

    public int getProductionOrderActualQty() {
        return productionOrderActualQty;
    }

    public void setProductionOrderActualQty(int productionOrderActualQty) {
        this.productionOrderActualQty = productionOrderActualQty;
    }

    public LocalDateTime getProductionOrderRequiredDeliveryDate() {
        return productionOrderRequiredDeliveryDate;
    }

    public void setProductionOrderRequiredDeliveryDate(LocalDateTime productionOrderRequiredDeliveryDate) {
        this.productionOrderRequiredDeliveryDate = productionOrderRequiredDeliveryDate;
    }

    public LocalDateTime getProductionOrderPlannedStartDate() {
        return productionOrderPlannedStartDate;
    }

    public void setProductionOrderPlannedStartDate(LocalDateTime productionOrderPlannedStartDate) {
        this.productionOrderPlannedStartDate = productionOrderPlannedStartDate;
    }

    public LocalDateTime getProductionOrderPlannedEndDate() {
        return productionOrderPlannedEndDate;
    }

    public void setProductionOrderPlannedEndDate(LocalDateTime productionOrderPlannedEndDate) {
        this.productionOrderPlannedEndDate = productionOrderPlannedEndDate;
    }

    public LocalDateTime getProductionOrderActualStartDate() {
        return productionOrderActualStartDate;
    }

    public void setProductionOrderActualStartDate(LocalDateTime productionOrderActualStartDate) {
        this.productionOrderActualStartDate = productionOrderActualStartDate;
    }

    public LocalDateTime getProductionOrderActualEndDate() {
        return productionOrderActualEndDate;
    }

    public void setProductionOrderActualEndDate(LocalDateTime productionOrderActualEndDate) {
        this.productionOrderActualEndDate = productionOrderActualEndDate;
    }

    public String getProductionOrderScheduleOrderId() {
        return productionOrderScheduleOrderId;
    }

    public void setProductionOrderScheduleOrderId(String productionOrderScheduleOrderId) {
        this.productionOrderScheduleOrderId = productionOrderScheduleOrderId;
    }
}
