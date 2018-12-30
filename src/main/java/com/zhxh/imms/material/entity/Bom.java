package com.zhxh.imms.material.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.AutoGeneration;
import com.zhxh.core.data.meta.annotation.DataTable;
import lombok.Getter;
import lombok.Setter;

@DataTable("bom")
@Getter
@Setter
public class Bom extends EntityObject {
    private String bomOrderId;
    private String componentTypeNo;
    private String componentMaterialId;
    private String componentAbstractMaterialId;
    private double componentQty;
    private String componentUomId;
    private String componentMaterialNoPath;
    private String componentMaterialNamePath;
    private String componentMaterialMatchRuleId;
    private boolean ifMainFabric;
}
