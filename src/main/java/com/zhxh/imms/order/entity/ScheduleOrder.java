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
    private String scheduleOrderStatus;
    private String scheduleOrderCode;
    private Long plantId;
    private Long workCenterId;
    private Long fgMaterialId;
    private int plannedQty;
    private String productionOrderCode;
    private LocalDateTime requiredDeliveryDate;
    private LocalDateTime plannedStartDate;
    private LocalDateTime plannedEndDate;
    private LocalDateTime actualStartDate;
    private LocalDateTime actualEndDate;

}
