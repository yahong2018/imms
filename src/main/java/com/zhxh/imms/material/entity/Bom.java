package com.zhxh.imms.material.entity;

import com.zhxh.core.data.EntityObject;

public class Bom implements EntityObject {
    private String rowId;
    private String bomOrderId;
    private String componentMaterialId;
    private String componentAbstractMaterialId;
    private double qty;
    private String componentMaterialUom;
    private String type;
    private String parentId;
    private String materialMatchRuleId;
    private boolean ifMainFabric;
    private String source;

    public String getType() {
        return type;
    }

    public String getRowId() {
        return rowId;
    }

    public String getBomOrderId() {
        return bomOrderId;
    }

    public String getSource() {
        return source;
    }

    public double getQty() {
        return qty;
    }

    public String getComponentAbstractMaterialId() {
        return componentAbstractMaterialId;
    }

    public String getComponentMaterialId() {
        return componentMaterialId;
    }

    public String getComponentMaterialUom() {
        return componentMaterialUom;
    }

    public String getMaterialMatchRuleId() {
        return materialMatchRuleId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public void setBomOrderId(String bomOrderId) {
        this.bomOrderId = bomOrderId;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setComponentAbstractMaterialId(String componentAbstractMaterialId) {
        this.componentAbstractMaterialId = componentAbstractMaterialId;
    }

    public void setComponentMaterialId(String componentMaterialId) {
        this.componentMaterialId = componentMaterialId;
    }

    public void setComponentMaterialUom(String componentMaterialUom) {
        this.componentMaterialUom = componentMaterialUom;
    }

    public void setIfMainFabric(boolean ifMainFabric) {
        this.ifMainFabric = ifMainFabric;
    }

    public void setMaterialMatchRuleId(String materialMatchRuleId) {
        this.materialMatchRuleId = materialMatchRuleId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public boolean getIfMainFabric() {
        return ifMainFabric;
    }
}
