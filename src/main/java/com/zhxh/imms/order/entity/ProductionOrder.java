package com.zhxh.imms.order.entity;

import com.zhxh.core.data.TraceableEntity;
import com.zhxh.core.data.meta.annotation.DataTableConfiguration;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@DataTableConfiguration("production_order")
@Getter
@Setter
public class ProductionOrder extends TraceableEntity<Long> {
    private String productionOrderNo;
    private Long bomOrderId;
    private Long operationRoutingOrderId;
    private int productionOrderStatus;   //各个状态的结构因为太复杂，如果由数据结构来反应，则难以具备可扩展性，所以需要由程序计算并更新，不能反应在数据结构上。
    private int priority;
    private Long requirementOrderId;
    private Long plantId;
    private Long workCenterId;
    private Long fgMaterialId;
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
    private Long scheduleOrderId;
}
