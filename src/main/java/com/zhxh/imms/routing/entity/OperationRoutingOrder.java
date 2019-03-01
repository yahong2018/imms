package com.zhxh.imms.routing.entity;

import com.zhxh.core.data.Entity;
import com.zhxh.core.data.meta.annotation.DataTableConfiguration;
import lombok.Getter;
import lombok.Setter;

@DataTableConfiguration("operation_routing_order")
@Getter
@Setter
public class OperationRoutingOrder extends Entity<Long> {
    private String operationRoutingOrderNo;
    private int operationRoutingType;
    private Long refId;
}