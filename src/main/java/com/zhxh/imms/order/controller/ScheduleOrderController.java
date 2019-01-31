package com.zhxh.imms.order.controller;

import com.zhxh.imms.order.entity.ScheduleOrder;
import com.zhxh.imms.order.service.ScheduleOrderService;
import com.zhxh.imms.order.vo.RequirementOrderVO;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@RequestMapping("/imms/order/scheduleOrder")
public class ScheduleOrderController {

    @Resource(name="scheduleOrderService")
    private ScheduleOrderService scheduleOrderService;

    @RequestMapping(value = "release")
    public String releaseScheduleOrder(RequirementOrderVO requirementOrderVO,ScheduleOrder scheduleOrder){
        return this.scheduleOrderService.release(requirementOrderVO,scheduleOrder);
    }

}
