package com.zhxh.imms.bus.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OperationRoutingDTO {
    private String operationNo;
    private String nextOperationNo;
    private String machineType;
    private Boolean ifOutsource;
    private String qaProcedure;
    private String requirement;
    private float standardTime;
    private double standardPrice;
    private String sectionType;
    private String requiredLevel;
    private String[] preOperations;
}
