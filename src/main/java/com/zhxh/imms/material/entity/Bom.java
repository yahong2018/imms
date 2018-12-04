package com.zhxh.imms.material.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.AutoGeneration;

public class Bom implements EntityObject {
    public final static String COMPONENT_TYPE_CUSTOM="C";
    public final static String COMPONENT_TYPE_DEFAULT="D";

    @AutoGeneration
    private String bomId;
    private String bomBomOrderId;
    private String componentMaterialId;
    private String componentAbstractMaterialId;
    private double componentQty;
    private String componentMaterialUomId;
    private String componentTypeNo;
    private String componentMaterialNoPath;
    private String componentMaterialNamePath;
    private String componentMaterialMatchRuleId;
    private boolean ifMainFabric;
    private String bomDataSource;

    private String parentBomId;

    public String getComponentMaterialNoPath() {
        return componentMaterialNoPath;
    }

    public String getComponentMaterialNamePath() {
        return componentMaterialNamePath;
    }

    public void setComponentMaterialNoPath(String componentMaterialNoPath) {
        this.componentMaterialNoPath = componentMaterialNoPath;
    }

    public void setComponentMaterialNamePath(String componentMaterialNamePath) {
        this.componentMaterialNamePath = componentMaterialNamePath;
    }

    public String getBomId() {
        return bomId;
    }

    public void setBomId(String bomId) {
        this.bomId = bomId;
    }

    public double getComponentQty() {
        return componentQty;
    }

    public void setComponentQty(double componentQty) {
        this.componentQty = componentQty;
    }

    public String getParentBomId() {
        return parentBomId;
    }

    public void setParentBomId(String parentBomId) {
        this.parentBomId = parentBomId;
    }

    public String getComponentAbstractMaterialId() {
        return componentAbstractMaterialId;
    }

    public String getComponentMaterialId() {
        return componentMaterialId;
    }

    public String getComponentMaterialUomId() {
        return componentMaterialUomId;
    }

    public void setComponentAbstractMaterialId(String componentAbstractMaterialId) {
        this.componentAbstractMaterialId = componentAbstractMaterialId;
    }

    public void setComponentMaterialId(String componentMaterialId) {
        this.componentMaterialId = componentMaterialId;
    }

    public void setComponentMaterialUomId(String componentMaterialUomId) {
        this.componentMaterialUomId = componentMaterialUomId;
    }

    public void setIfMainFabric(boolean ifMainFabric) {
        this.ifMainFabric = ifMainFabric;
    }

    public boolean getIfMainFabric() {
        return ifMainFabric;
    }

    public String getBomDataSource() {
        return bomDataSource;
    }

    public void setBomDataSource(String bomDataSource) {
        this.bomDataSource = bomDataSource;
    }

    public String getComponentTypeNo() {
        return componentTypeNo;
    }

    public void setComponentTypeNo(String componentTypeNo) {
        this.componentTypeNo = componentTypeNo;
    }

    public String getComponentMaterialMatchRuleId() {
        return componentMaterialMatchRuleId;
    }

    public void setComponentMaterialMatchRuleId(String componentMaterialMatchRuleId) {
        this.componentMaterialMatchRuleId = componentMaterialMatchRuleId;
    }

    public String getBomBomOrderId() {
        return bomBomOrderId;
    }

    public void setBomBomOrderId(String bomBomOrderId) {
        this.bomBomOrderId = bomBomOrderId;
    }
}
