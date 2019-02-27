package com.zhxh.imms.order.controller;

import com.zhxh.imms.order.service.ScheduleOrderService;
import com.zhxh.imms.order.dto.ScheduleOrderDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@RequestMapping("/imms/order/scheduleOrder")
public class ScheduleOrderController {

    @Resource(name="scheduleOrderService")
    private ScheduleOrderService scheduleOrderService;

    @RequestMapping(value = "receiveFromAps.handler")
    public void receiveScheduleFromAps(ScheduleOrderDTO scheduleOrder){
        this.scheduleOrderService.receiveScheduleFromAps(scheduleOrder);
    }

}
