package com.zhxh.imms.material.entity;

import com.zhxh.core.data.EntityObject;


public class Material implements EntityObject {
    private String rowId;
    private String materialNo;
    private String materialTypeId;
    private String bomOrderId;
    private String operationRoutingOrderId;
    private String name;
    private String unit;
    private double  width;
    private double weight;
    private String sizeId;
    private double price;
    private String color;
    private String description;

    public String getRowId() {
        return rowId;
    }

    public String getMaterialNo() {
        return materialNo;
    }

    public String getMaterialTypeId() {
        return materialTypeId;
    }

    public String getBomOrderId() {
        return bomOrderId;
    }

    public String getOperationRoutingOrderId() {
        return operationRoutingOrderId;
    }

    public String getName() {
        return name;
    }

    public double getWidth() {
        return width;
    }

    public String getUnit() {
        return unit;
    }

    public double getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public String getSizeId() {
        return sizeId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public void setBomOrderId(String bomOrderId) {
        this.bomOrderId = bomOrderId;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMaterialNo(String materialNo) {
        this.materialNo = materialNo;
    }

    public void setMaterialTypeId(String materialTypeId) {
        this.materialTypeId = materialTypeId;
    }

    public void setOperationRoutingOrderId(String operationRoutingOrderId) {
        this.operationRoutingOrderId = operationRoutingOrderId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSizeId(String sizeId) {
        this.sizeId = sizeId;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
