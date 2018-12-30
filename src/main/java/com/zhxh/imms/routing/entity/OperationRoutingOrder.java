package com.zhxh.imms.routing.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.DataTable;
import lombok.Getter;
import lombok.Setter;

@DataTable("operation_routing_order")
@Getter
@Setter
public class OperationRoutingOrder extends EntityObject {
    private String operationRoutingOrderNo;
    private int operationRoutingType;
}