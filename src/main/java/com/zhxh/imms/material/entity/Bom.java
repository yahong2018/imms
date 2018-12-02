package com.zhxh.imms.material.entity;

import com.zhxh.core.data.EntityObject;

public class Bom implements EntityObject {
    private String bomId;
    private String bomOrderId;
    private String componentMaterialId;
    private String componentAbstractMaterialId;
    private double componentQty;
    private String componentMaterialUomId;
    private String parentBomId;
    private String materialMatchRuleId;
    private boolean ifMainFabric;
    private String bomSource;

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

    public String getBomSource() {
        return bomSource;
    }

    public void setBomSource(String bomSource) {
        this.bomSource = bomSource;
    }

    public String getBomOrderId() {
        return bomOrderId;
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

    public String getMaterialMatchRuleId() {
        return materialMatchRuleId;
    }

    public void setBomOrderId(String bomOrderId) {
        this.bomOrderId = bomOrderId;
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

    public void setMaterialMatchRuleId(String materialMatchRuleId) {
        this.materialMatchRuleId = materialMatchRuleId;
    }

    public boolean getIfMainFabric() {
        return ifMainFabric;
    }
}
