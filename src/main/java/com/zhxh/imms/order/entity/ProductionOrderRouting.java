package com.zhxh.imms.order.entity;

import com.zhxh.core.data.EntityObject;

public class ProductionOrderRouting implements EntityObject {
    public String getProductionOrderRoutingId() {
        return productionOrderRoutingId;
    }

    public void setProductionOrderRoutingId(String productionOrderRoutingId) {
        this.productionOrderRoutingId = productionOrderRoutingId;
    }

    public String getProductionOrderRoutingProductionOrderId() {
        return productionOrderRoutingProductionOrderId;
    }

    public void setProductionOrderRoutingProductionOrderId(String productionOrderRoutingProductionOrderId) {
        this.productionOrderRoutingProductionOrderId = productionOrderRoutingProductionOrderId;
    }

    public String getProductionOrderRoutingOperationId() {
        return productionOrderRoutingOperationId;
    }

    public void setProductionOrderRoutingOperationId(String productionOrderRoutingOperationId) {
        this.productionOrderRoutingOperationId = productionOrderRoutingOperationId;
    }

    public String getProductionOrderRoutingQaProcedure() {
        return productionOrderRoutingQaProcedure;
    }

    public void setProductionOrderRoutingQaProcedure(String productionOrderRoutingQaProcedure) {
        this.productionOrderRoutingQaProcedure = productionOrderRoutingQaProcedure;
    }

    public String getProductionOrderRoutingMachineTypeId() {
        return productionOrderRoutingMachineTypeId;
    }

    public void setProductionOrderRoutingMachineTypeId(String productionOrderRoutingMachineTypeId) {
        this.productionOrderRoutingMachineTypeId = productionOrderRoutingMachineTypeId;
    }

    public float getProductionOrderRoutingStandardTime() {
        return productionOrderRoutingStandardTime;
    }

    public void setProductionOrderRoutingStandardTime(float productionOrderRoutingStandardTime) {
        this.productionOrderRoutingStandardTime = productionOrderRoutingStandardTime;
    }

    public float getProductionOrderRoutingStandardPrice() {
        return productionOrderRoutingStandardPrice;
    }

    public void setProductionOrderRoutingStandardPrice(float productionOrderRoutingStandardPrice) {
        this.productionOrderRoutingStandardPrice = productionOrderRoutingStandardPrice;
    }

    public String getProductionOrderRoutingSectionType() {
        return productionOrderRoutingSectionType;
    }

    public void setProductionOrderRoutingSectionType(String productionOrderRoutingSectionType) {
        this.productionOrderRoutingSectionType = productionOrderRoutingSectionType;
    }

    public String getProductionOrderRoutingPreOperationId() {
        return productionOrderRoutingPreOperationId;
    }

    public void setProductionOrderRoutingPreOperationId(String productionOrderRoutingPreOperationId) {
        this.productionOrderRoutingPreOperationId = productionOrderRoutingPreOperationId;
    }

    public String getProductionOrderRoutingSopFilePath() {
        return productionOrderRoutingSopFilePath;
    }

    public void setProductionOrderRoutingSopFilePath(String productionOrderRoutingSopFilePath) {
        this.productionOrderRoutingSopFilePath = productionOrderRoutingSopFilePath;
    }

    private String productionOrderRoutingId;
    private String productionOrderRoutingProductionOrderId; 
    private String productionOrderRoutingOperationId;        
    private String productionOrderRoutingQaProcedure;
    private String productionOrderRoutingMachineTypeId;
    private float productionOrderRoutingStandardTime;
    private float productionOrderRoutingStandardPrice;
    private String productionOrderRoutingSectionType;
    private String productionOrderRoutingPreOperationId;    
    private String productionOrderRoutingSopFilePath;
    

}
