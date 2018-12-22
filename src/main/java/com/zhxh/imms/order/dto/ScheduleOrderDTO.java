package com.zhxh.imms.order.dto;

import com.zhxh.imms.order.entity.RequirementOrder;
import com.zhxh.imms.order.entity.ScheduleOrder;

public class ScheduleOrderDTO extends ScheduleOrder {
    private RequirementOrder requirementOrder;

    public RequirementOrder getRequirementOrder() {
        return requirementOrder;
    }

    public void setRequirementOrder(RequirementOrder requirementOrder) {
        this.requirementOrder = requirementOrder;
    }
}
