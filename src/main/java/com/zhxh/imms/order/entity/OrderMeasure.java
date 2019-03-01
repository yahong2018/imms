package com.zhxh.imms.order.entity;

import com.zhxh.core.data.Entity;
import com.zhxh.core.data.meta.annotation.DataTableConfiguration;
import lombok.Getter;
import lombok.Setter;

@DataTableConfiguration("order_measure_data")
@Getter
@Setter
public class OrderMeasure extends Entity<Long> {
    private Long orderId;
    private int refRecordType;
    private String bodyNo;
    private String measureData;
}
