package com.zhxh.imms.routing.entity;

import com.zhxh.core.data.Entity;
import com.zhxh.core.data.meta.annotation.DataTableConfiguration;
import lombok.Getter;
import lombok.Setter;

@DataTableConfiguration("operation")
@Getter
@Setter
public class Operation extends Entity<Long> {
    private String  operationNo;
    private String  operationName;
    private String  standardOperationProcedure;
    private Long  machineTypeId;
    private float   standardTime;
    private double  standardPrice;
    private String  sectionType;
    private String  sectionName;
    private Boolean ifOutsource;
    private String  qaProcedure;
    private String  requirement;
    private String  requirementLevel;
    private String  designPartCode;
    private String  partCode;
    private String  partType;
}
