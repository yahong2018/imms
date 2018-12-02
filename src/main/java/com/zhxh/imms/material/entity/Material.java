package com.zhxh.imms.material.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.AutoGeneration;
import com.zhxh.core.data.meta.annotation.CheckUnique;


public class Material implements EntityObject {
    @AutoGeneration
    private String materialId;

    @CheckUnique
    private String materialNo;

    private String materialMaterialTypeId;
    private String materialName;
    private String materialUomId;
    private double materialWidth;
    private double materialWeight;
    private String materialSizeId;
    private double materialPrice;
    private String materialColor;
    private String materialDescription;

    public String getMaterialId() {
        return materialId;
    }

    public String getMaterialNo() {
        return materialNo;
    }

    public String getMaterialMaterialTypeId() {
        return materialMaterialTypeId;
    }

    public String getMaterialName() {
        return materialName;
    }

    public String getMaterialUomId() {
        return materialUomId;
    }

    public double getMaterialWidth() {
        return materialWidth;
    }

    public double getMaterialWeight() {
        return materialWeight;
    }

    public String getMaterialSizeId() {
        return materialSizeId;
    }

    public double getMaterialPrice() {
        return materialPrice;
    }

    public String getMaterialColor() {
        return materialColor;
    }

    public String getMaterialDescription() {
        return materialDescription;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public void setMaterialNo(String materialNo) {
        this.materialNo = materialNo;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public void setMaterialUomId(String materialUomId) {
        this.materialUomId = materialUomId;
    }

    public void setMaterialSizeId(String materialSizeId) {
        this.materialSizeId = materialSizeId;
    }

    public void setMaterialMaterialTypeId(String materialMaterialTypeId) {
        this.materialMaterialTypeId = materialMaterialTypeId;
    }

    public void setMaterialColor(String materialColor) {
        this.materialColor = materialColor;
    }

    public void setMaterialDescription(String materialDescription) {
        this.materialDescription = materialDescription;
    }

    public void setMaterialPrice(double materialPrice) {
        this.materialPrice = materialPrice;
    }

    public void setMaterialWeight(double materialWeight) {
        this.materialWeight = materialWeight;
    }

    public void setMaterialWidth(double materialWidth) {
        this.materialWidth = materialWidth;
    }
}
