package com.zhxh.imms.routing.entity;

import com.zhxh.core.data.Entity;
import com.zhxh.core.data.meta.annotation.DataTableConfiguration;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@DataTableConfiguration("operation_routing")
@Getter
@Setter
public class OperationRouting extends Entity<Long> {
    private Long operationRoutingOrderId;
    private Long operationId;
    private String qaProcedure;
    private double standardPrice;
    private String sectionType;
    private Long machineTypeId;
    private Long actualStationId;
    private Long operatorId;
    private float standardTime;
    private float actualTime;
    private Long preOperationId;
    private Long preRoutingId;
    private String sopFilePath;
    private int operationRoutingStatus;
    private String requiredLevel;
    private int scrapQty;
    private int completeQty;
    private int sequenceNo;
    private String partType;
    private Boolean ifOutsource;
    private LocalDateTime pullInTime;
    private LocalDateTime pullOutTime;
}
