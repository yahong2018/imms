package com.zhxh.imms.material.vo;

import com.zhxh.core.data.ParentChildVO;
import com.zhxh.imms.material.entity.Bom;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
public class BomVO extends Bom implements ParentChildVO {
    private final static Map<String,String> componentTypeNames = new HashMap<String, String>(){
        {
            put("CUSTOM","定制");
            put("DEFAULT","缺省");
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
}
