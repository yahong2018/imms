package com.zhxh.imms.material.vo;

import com.zhxh.imms.material.entity.Material;

public class MaterialVO extends Material {
    private String materialTypeNo;
    private String materialTypeName;
    private String sizeNo;
    private String sizeName;
    private String uomNo;
    private String uomName;


    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public String getMaterialTypeName() {
        return materialTypeName;
    }

    public void setMaterialTypeName(String materialTypeName) {
        this.materialTypeName = materialTypeName;
    }

    public String getMaterialTypeNo() {
        return materialTypeNo;
    }

    public String getSizeNo() {
        return sizeNo;
    }

    public String getUomNo() {
        return uomNo;
    }

    public String getUomName() {
        return uomName;
    }

    public void setMaterialTypeNo(String materialTypeNo) {
        this.materialTypeNo = materialTypeNo;
    }

    public void setSizeNo(String sizeNo) {
        this.sizeNo = sizeNo;
    }

    public void setUomName(String uomName) {
        this.uomName = uomName;
    }

    public void setUomNo(String uomNo) {
        this.uomNo = uomNo;
    }
}
