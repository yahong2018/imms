package com.zhxh.imms.material.vo;

import com.zhxh.imms.material.entity.Material;

public class MaterialVO extends Material {
    private String bomOrderCode;
    private String materialTypeCode;
    private String materialTypeName;
    private String operationRoutingOrderCode;
    private String sizeCode;
    private String sizeName;
    private String unitCode;
    private String unitName;

    public String getMaterialTypeCode() {
        return materialTypeCode;
    }

    public String getBomOrderCode() {
        return bomOrderCode;
    }

    public String getOperationRoutingOrderCode() {
        return operationRoutingOrderCode;
    }

    public String getSizeCode() {
        return sizeCode;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setBomOrderCode(String bomOrderCode) {
        this.bomOrderCode = bomOrderCode;
    }

    public void setOperationRoutingOrderCode(String operationRoutingOrderCode) {
        this.operationRoutingOrderCode = operationRoutingOrderCode;
    }

    public void setSizeCode(String sizeCode) {
        this.sizeCode = sizeCode;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public void setMaterialTypeCode(String materialTypeCode) {
        this.materialTypeCode = materialTypeCode;
    }

    public String getMaterialTypeName() {
        return materialTypeName;
    }

    public void setMaterialTypeName(String materialTypeName) {
        this.materialTypeName = materialTypeName;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}
