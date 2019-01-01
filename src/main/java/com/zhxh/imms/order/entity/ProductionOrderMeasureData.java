package com.zhxh.imms.order.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.DataTable;
import lombok.Getter;
import lombok.Setter;

@DataTable("production_order_measure_data")
@Getter
@Setter
public class ProductionOrderMeasureData extends EntityObject {
    private String productionOrderId;
    private String measureBodyNo;
    private String measureBody;
    private String measureData;
}
