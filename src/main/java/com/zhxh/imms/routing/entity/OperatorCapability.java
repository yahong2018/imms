package com.zhxh.imms.routing.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.DataTable;
import lombok.Getter;
import lombok.Setter;

@DataTable("operator_capability")
@Getter
@Setter
public class OperatorCapability extends EntityObject {
    private String operatorId;
    private String operationId;
    private String level;
}
