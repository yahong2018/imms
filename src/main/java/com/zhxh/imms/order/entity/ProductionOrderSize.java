package com.zhxh.imms.order.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.DataTable;
import lombok.Getter;
import lombok.Setter;

@DataTable("production_order_size")
@Getter
@Setter
public class ProductionOrderSize extends EntityObject {
    private String productionOrderId;
    private String size;
    private int plannedQty;
    private int actualQty;
}
