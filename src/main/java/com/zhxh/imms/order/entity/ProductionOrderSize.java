package com.zhxh.imms.order.entity;

import com.zhxh.core.data.EntityObject;

public class ProductionOrderSize extends EntityObject {
    private String productionOrderSizeId;
    private String productionOrderSizeProductionOrderId;
    private String productionOrderSizeSize;
    private int productionOrderSizePlannedQty;
    private int productionOrderSizeActualQty;

    public String getProductionOrderSizeId() {
        return productionOrderSizeId;
    }

    public void setProductionOrderSizeId(String productionOrderSizeId) {
        this.productionOrderSizeId = productionOrderSizeId;
    }

    public String getProductionOrderSizeProductionOrderId() {
        return productionOrderSizeProductionOrderId;
    }

    public void setProductionOrderSizeProductionOrderId(String productionOrderSizeProductionOrderId) {
        this.productionOrderSizeProductionOrderId = productionOrderSizeProductionOrderId;
    }

    public String getProductionOrderSizeSize() {
        return productionOrderSizeSize;
    }

    public void setProductionOrderSizeSize(String productionOrderSizeSize) {
        this.productionOrderSizeSize = productionOrderSizeSize;
    }

    public int getProductionOrderSizePlannedQty() {
        return productionOrderSizePlannedQty;
    }

    public void setProductionOrderSizePlannedQty(int productionOrderSizePlannedQty) {
        this.productionOrderSizePlannedQty = productionOrderSizePlannedQty;
    }

    public int getProductionOrderSizeActualQty() {
        return productionOrderSizeActualQty;
    }

    public void setProductionOrderSizeActualQty(int productionOrderSizeActualQty) {
        this.productionOrderSizeActualQty = productionOrderSizeActualQty;
    }
}
