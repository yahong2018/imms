package com.zhxh.imms.material.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.CheckUnique;
import com.zhxh.core.data.meta.annotation.DataTableConfiguration;
import lombok.Getter;
import lombok.Setter;

@DataTableConfiguration("material")
@Getter
@Setter
public class Material extends EntityObject<Long> {
    @CheckUnique
    private String materialNo;
    private Long materialTypeId;
    private String materialName;
    private Long materialUomId;
    private double materialWidth;
    private double materialWeight;
    private Long materialSizeId;
    private double materialPrice;
    private String materialColor;
    private String materialDescription;
}
