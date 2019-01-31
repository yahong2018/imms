package com.zhxh.imms.order.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.DataTableConfiguration;
import lombok.Getter;
import lombok.Setter;

@DataTableConfiguration("production_order_measure_data")
@Getter
@Setter
public class ProductionOrderMeasureData extends EntityObject<Long> {
    private Long productionOrderId;
    private String measureBodyNo;
    private String measureBody;
    private String measureData;
}
