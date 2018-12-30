package com.zhxh.imms.order.entity;

import com.zhxh.core.data.TraceableEntity;
import com.zhxh.core.data.meta.annotation.DataTable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@DataTable("schedule_order")
@Getter
@Setter
public class ScheduleOrder extends TraceableEntity {
    private String scheduleOrderStatus;
    private String scheduleOrderCode;
    private String plantId;
    private String workCenterId;
    private String fgMaterialId;
    private int plannedQty;
    private String productionOrderCode;
    private LocalDateTime requiredDeliveryDate;
    private LocalDateTime plannedStartDate;
    private LocalDateTime plannedEndDate;
    private LocalDateTime actualStartDate;
    private LocalDateTime actualEndDate;

}
