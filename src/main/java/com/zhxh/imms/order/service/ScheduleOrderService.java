package com.zhxh.imms.order.service;

import com.zhxh.imms.kanban.EventType;
import com.zhxh.imms.order.dao.ScheduleOrderDAO;
import com.zhxh.imms.order.entity.ProductionOrder;
import com.zhxh.imms.order.entity.RequirementOrder;
import com.zhxh.imms.order.entity.ScheduleOrder;
import com.zhxh.imms.order.vo.RequirementOrderVO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

@Component("scheduleOrderService")
public class ScheduleOrderService {
    @Resource(name = "scheduleOrderDAO")
    private ScheduleOrderDAO scheduleOrderDAO;

    @Resource(name = "requirementOrderService")
    private RequirementOrderService requirementOrderService;

    @Resource(name="productionOrderService")
    private ProductionOrderService productionOrderService;

    public ScheduleOrderService() {
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public String release(RequirementOrderVO requirementOrderVO, ScheduleOrder scheduleOrder) {
        //1.保存ScheduleOrder
        this.scheduleOrderDAO.insert(scheduleOrder);
        //2.保存需求订单
        RequirementOrder requirementOrder = this.requirementOrderService.createFromVo (requirementOrderVO);
        //3.创建生产订单
        ProductionOrder productionOrder = this.productionOrderService.createProductionOrder(requirementOrder,scheduleOrder);
        //4.通知可视化进行数据更新
        this.publishEvent(EventType.ISSUE_REQUIREMENT_ORDER, requirementOrderVO.getRequirementOrderNo());
        //5.返回生产订单的单号
        return productionOrder.getProductionOrderNo();
    }

    public void publishEvent(String eventId, Object data) {

    }



}
