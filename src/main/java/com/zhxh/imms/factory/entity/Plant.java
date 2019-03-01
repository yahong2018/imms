package com.zhxh.imms.factory.entity;

import com.zhxh.core.data.Entity;
import com.zhxh.core.data.meta.annotation.DataTableConfiguration;
import lombok.Getter;
import lombok.Setter;

@DataTableConfiguration("plant")
@Getter
@Setter
public class Plant extends Entity<Long> {
    private String plantNo;
    private String plantName;
    private String description;
    private Double costPriceRatio;
}
