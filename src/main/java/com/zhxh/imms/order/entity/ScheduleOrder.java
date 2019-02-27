package com.zhxh.imms.order.entity;

import com.zhxh.core.data.TraceableEntity;
import com.zhxh.core.data.meta.annotation.DataTableConfiguration;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@DataTableConfiguration("schedule_order")
@Getter
@Setter
public class ScheduleOrder extends TraceableEntity<Long> {
    private String scheduleOrderNo;
    private String requirementOrderNo;
    private String productionOrderNo;

    private Long plantId;
    private String plantNo;
    private Long workCenterId;
    private String workCenterNo;
    private Long fgMaterialId;
    private String fgMaterialNo;

    private int qtyPlanned;
    private int qtyActual;

    private LocalDateTime dateRequiredDelivery;
    private LocalDateTime datePlannedStart;
    private LocalDateTime datePlannedEnd;
    private LocalDateTime dateActualStart;
    private LocalDateTime dateActualEnd;

    private byte orderStatus;
}
