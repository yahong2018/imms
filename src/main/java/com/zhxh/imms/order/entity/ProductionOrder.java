package com.zhxh.imms.order.entity;

import com.zhxh.core.data.TraceableEntity;
import com.zhxh.core.data.meta.annotation.DataTable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@DataTable("production_order")
@Getter
@Setter
public class ProductionOrder extends TraceableEntity {
    private String productionOrderId;
    private String productionOrderNo;
    private String bomOrderId;
    private String operationRoutingOrderId;
    private int productionOrderStatus;
    private int priority;
    private String requirementOrderId;
    private String plantId;
    private String workCenterId;
    private String fgMaterialId;
    private int plannedQty;
    private int finishedQty;
    private int secondQualityQty;
    private int defectQty;
    private int actualQty;
    private LocalDateTime requiredDeliveryDate;
    private LocalDateTime plannedStartDate;
    private LocalDateTime plannedEndDate;
    private LocalDateTime actualStartDate;
    private LocalDateTime actualEndDate;
    private String scheduleOrderId;

}
