package com.zhxh.imms.material.vo;

import com.zhxh.imms.material.entity.Bom;

public class BomVO extends Bom {
    private String bomOrderNo;
    private String componentMaterialNo;
    private String componentMaterialName;

    private String componentAbstractMaterialNo;
    private String componentAbstractMaterialName;

    private String componentMaterialUomNo;
    private String componentMaterialUomName;

    private String materialMatchRuleNo;
    private String materialMatchRuleName;


    public String getBomOrderNo() {
        return bomOrderNo;
    }

    public String getComponentAbstractMaterialNo() {
        return componentAbstractMaterialNo;
    }

    public String getComponentAbstractMaterialName() {
        return componentAbstractMaterialName;
    }

    public String getComponentMaterialName() {
        return componentMaterialName;
    }

    public String getComponentMaterialNo() {
        return componentMaterialNo;
    }

    public String getComponentMaterialUomName() {
        return componentMaterialUomName;
    }

    public String getComponentMaterialUomNo() {
        return componentMaterialUomNo;
    }

    public String getMaterialMatchRuleNo() {
        return materialMatchRuleNo;
    }

    public String getMaterialMatchRuleName() {
        return materialMatchRuleName;
    }

    public void setBomOrderNo(String bomOrderNo) {
        this.bomOrderNo = bomOrderNo;
    }

    public void setComponentAbstractMaterialName(String componentAbstractMaterialName) {
        this.componentAbstractMaterialName = componentAbstractMaterialName;
    }

    public void setComponentAbstractMaterialNo(String componentAbstractMaterialNo) {
        this.componentAbstractMaterialNo = componentAbstractMaterialNo;
    }

    public void setComponentMaterialName(String componentMaterialName) {
        this.componentMaterialName = componentMaterialName;
    }

    public void setComponentMaterialNo(String componentMaterialNo) {
        this.componentMaterialNo = componentMaterialNo;
    }

    public void setComponentMaterialUomName(String componentMaterialUomName) {
        this.componentMaterialUomName = componentMaterialUomName;
    }

    public void setComponentMaterialUomNo(String componentMaterialUomNo) {
        this.componentMaterialUomNo = componentMaterialUomNo;
    }

    public void setMaterialMatchRuleName(String materialMatchRuleName) {
        this.materialMatchRuleName = materialMatchRuleName;
    }

    public void setMaterialMatchRuleNo(String materialMatchRuleNo) {
        this.materialMatchRuleNo = materialMatchRuleNo;
    }

}
