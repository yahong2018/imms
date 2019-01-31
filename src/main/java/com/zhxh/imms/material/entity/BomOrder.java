package com.zhxh.imms.material.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.CheckUnique;
import com.zhxh.core.data.meta.annotation.DataTableConfiguration;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@DataTableConfiguration("bom_order")
@Getter
@Setter
public class BomOrder extends EntityObject<Long>{
    @CheckUnique
    private String bomOrderNo;
    private int bomOrderTypeNo;
    private Long refId;

    private final static Map<String, String> bomTypeNames = new HashMap<String, String>() {
        {
            put("PART", "部件BOM");
            put("STANDARD", "基准BOM");
            put("ORDER", "订单BOM");
            put("DESIGN", "设计BOM");
            put("MANUFACTURE", "生产BOM");
            put("WORK", "作业BOM");
        }
    };
}
