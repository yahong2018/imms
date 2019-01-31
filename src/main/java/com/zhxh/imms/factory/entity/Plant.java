package com.zhxh.imms.factory.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.DataTableConfiguration;
import lombok.Getter;
import lombok.Setter;

@DataTableConfiguration("plant")
@Getter
@Setter
public class Plant extends EntityObject<Long> {
    private String plantNo;
    private String plantName;
    private String description;
    private Double costPriceRatio;
}
