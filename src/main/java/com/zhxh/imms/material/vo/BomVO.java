package com.zhxh.imms.material.vo;

import com.zhxh.core.data.ParentChildVO;
import com.zhxh.imms.material.entity.Bom;

import java.util.HashMap;
import java.util.Map;

public class BomVO extends Bom implements ParentChildVO {
    private final static Map<String,String> componentTypeNames = new HashMap<String, String>(){
        {
            put(COMPONENT_TYPE_CUSTOM,"定制");
            put(COMPONENT_TYPE_DEFAULT,"缺省");
        }
    };

    private Object[] children;
    private String bomOrderNo;
    private String componentMaterialNo;
    private String componentMaterialName;

    private String componentAbstractMaterialNo;
    private String componentAbstractMaterialName;

    private String componentMaterialUomNo;
    private String componentMaterialUomName;

    private String componentMaterialMatchRuleNo;
    private String componentMaterialMatchRuleName;

    public String getComponentTypeName(){
       if(componentTypeNames.containsKey(this.getComponentTypeNo())){
           return componentTypeNames.get(this.getComponentTypeNo());
       }
       return this.getComponentTypeNo();
    }

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

    public String getComponentMaterialMatchRuleName() {
        return componentMaterialMatchRuleName;
    }

    public String getComponentMaterialMatchRuleNo() {
        return componentMaterialMatchRuleNo;
    }

    public void setComponentMaterialMatchRuleName(String componentMaterialMatchRuleName) {
        this.componentMaterialMatchRuleName = componentMaterialMatchRuleName;
    }

    public void setComponentMaterialMatchRuleNo(String componentMaterialMatchRuleNo) {
        this.componentMaterialMatchRuleNo = componentMaterialMatchRuleNo;
    }

    @Override
    public Object[] getChildren() {
        return this.children;
    }

    @Override
    public void setChildren(Object[] children) {
        this.children = children;
    }
}
