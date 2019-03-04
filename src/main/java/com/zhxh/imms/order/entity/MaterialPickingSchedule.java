package com.zhxh.imms.order.entity;

import com.zhxh.core.data.TraceableEntity;
import com.zhxh.core.data.meta.annotation.DataTableConfiguration;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@DataTableConfiguration("material_picking_schedule")
@Getter
@Setter
public class MaterialPickingSchedule /*领料计划单*/ extends TraceableEntity<Long> {
    private String materialPickingScheduleNo;
    private Long productionOrderId;
    private int materialPickingOrderStatus;
    private LocalDateTime plannedPickingDate;
    private LocalDateTime actualPickingDate;
    private Long operatorId;
}
