package com.zhxh.imms.material.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.DataTableConfiguration;
import lombok.Getter;
import lombok.Setter;

@DataTableConfiguration("bom")
@Getter
@Setter
public class Bom extends EntityObject<Long> {
    private Long bomOrderId;
    private String componentTypeNo;
    private Long componentMaterialId;
    private Long componentAbstractMaterialId;
    private double componentQty;
    private Long componentUomId;
    private String componentMaterialNoPath;
    private String componentMaterialNamePath;
    private Long componentMaterialMatchRuleId;
    private boolean ifMainFabric;
}
