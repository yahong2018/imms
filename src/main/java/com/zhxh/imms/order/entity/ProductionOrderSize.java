package com.zhxh.imms.order.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.DataTableConfiguration;
import lombok.Getter;
import lombok.Setter;

@DataTableConfiguration("production_order_size")
@Getter
@Setter
public class ProductionOrderSize extends EntityObject<Long> {
    private Long productionOrderId;
    private String size;
    private int plannedQty;
    private int actualQty;
}
