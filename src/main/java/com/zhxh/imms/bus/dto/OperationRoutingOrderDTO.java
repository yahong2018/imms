package com.zhxh.imms.bus.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OperationRoutingOrderDTO {
    private String productionOrderNo;
    private String materialNo;
    private OperationRoutingDTO[] operationRoutings;
}
