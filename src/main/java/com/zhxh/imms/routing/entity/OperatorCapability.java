package com.zhxh.imms.routing.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.DataTableConfiguration;
import lombok.Getter;
import lombok.Setter;

@DataTableConfiguration("operator_capability")
@Getter
@Setter
public class OperatorCapability extends EntityObject<Long> {
    private Long operatorId;
    private Long operationId;
    private String level;
}
