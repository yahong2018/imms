package com.zhxh.imms.order.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.DataTableConfiguration;
import lombok.Getter;
import lombok.Setter;

@DataTableConfiguration("order_size")
@Getter
@Setter
public class OrderSize extends EntityObject<Long> {
    private Long orderId;
    private int refRecordType;
    private Long sizeId;
    private String sizeCode;
    private int qtyPlanned;
    private int qtyActual;
}
