package com.zhxh.imms.routing.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.DataTable;
import lombok.Getter;
import lombok.Setter;

@DataTable("operation")
@Getter
@Setter
public class Operation extends EntityObject {
    private String  operationNo;
    private String  operationName;
    private String  standardOperationProcedure;
    private String  machineTypeId;
    private float   standardTime;
    private float   standardPrice;
    private String  partType;
    private String  sectionType;
    private String  sectionName;
    private boolean ifOutsource;
    private String  qaProcedure;
    private String  requirement;
    private String  level;
    private String  designPartCode;
    private String  partCode;

}
