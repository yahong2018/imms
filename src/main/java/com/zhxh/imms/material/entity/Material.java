package com.zhxh.imms.material.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.AutoGeneration;
import com.zhxh.core.data.meta.annotation.CheckUnique;
import com.zhxh.core.data.meta.annotation.DataTable;
import lombok.Getter;
import lombok.Setter;

@DataTable("material")
@Getter
@Setter
public class Material extends EntityObject {
    @CheckUnique
    private String materialNo;
    private String materialTypeId;
    private String materialName;
    private String materialUomId;
    private double materialWidth;
    private double materialWeight;
    private String materialSizeId;
    private double materialPrice;
    private String materialColor;
    private String materialDescription;
}
