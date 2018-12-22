package com.zhxh.imms.order.controller;

import com.zhxh.imms.order.entity.ScheduleOrder;
import com.zhxh.imms.order.logic.ScheduleOrderLogic;
import com.zhxh.imms.order.vo.RequirementOrderVO;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@RequestMapping("/imms/order/scheduleOrder")
public class ScheduleOrderController {

    @Resource(name="scheduleOrderLogic")
    private ScheduleOrderLogic scheduleOrderLogic;

    @RequestMapping(value = "issue")
    public String issueScheduleOrder(RequirementOrderVO requirementOrderVO,ScheduleOrder scheduleOrder){
        return this.scheduleOrderLogic.issue(requirementOrderVO,scheduleOrder);
    }

}
