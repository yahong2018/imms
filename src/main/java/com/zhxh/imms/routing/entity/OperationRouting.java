package com.zhxh.imms.routing.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.DataTableConfiguration;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@DataTableConfiguration("operation_routing")
@Getter
@Setter
public class OperationRouting extends EntityObject<Long> {
    private Long        operationId;
    private Long        operationRoutingOrderId;
    private String        qaProcedure;
    private float         standardPrice;
    private String        sectionType;
    private Long        machineTypeId;
    private Long        actualStationId;
    private Long        operatorId;
    private float         standardTime;
    private float         actualTime;
    private Long        preOperationId;
    private String        sopFilePath;
    private int           operationRoutingStatus;
    private String        requiredLevel;
    private int           scrapQty;
    private int           completeQty;
    private Long        preRoutingId;
    private int           sequenceNo;
    private String        partType;
    private String        ifOutsource;
    private LocalDateTime pullInTime;
    private LocalDateTime pullOutTime;
}
