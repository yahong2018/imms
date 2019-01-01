package com.zhxh.imms.routing.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.DataTable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@DataTable("operation_routing")
@Getter
@Setter
public class OperationRouting extends EntityObject {
    private String        operationId;
    private String        operationRoutingOrderId;
    private String        qaProcedure;
    private float         standardPrice;
    private String        sectionType;
    private String        machineTypeId;
    private String        actualStationId;
    private String        operatorId;
    private float         standardTime;
    private float         actualTime;
    private String        preOperationId;
    private String        sopFilePath;
    private int           operationRoutingStatus;
    private String        requiredLevel;
    private int           scrapQty;
    private int           completeQty;
    private String        preRoutingId;
    private int           sequenceNo;
    private String        partType;
    private String        ifOutsource;
    private LocalDateTime pullInTime;
    private LocalDateTime pullOutTime;
}
