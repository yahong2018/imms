package com.zhxh.imms.factory.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.DataTable;
import lombok.Getter;
import lombok.Setter;

@DataTable("plant")
@Getter
@Setter
public class Plant extends EntityObject {
    private String plantNo;
    private String plantName;
    private String description;
    private Double costPriceRatio;
}
