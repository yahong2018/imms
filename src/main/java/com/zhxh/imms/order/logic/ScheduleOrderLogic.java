package com.zhxh.imms.order.logic;

import com.zhxh.imms.kanban.EventType;
import com.zhxh.imms.order.dao.ScheduleOrderDAO;
import com.zhxh.imms.order.entity.ProductionOrder;
import com.zhxh.imms.order.entity.RequirementOrder;
import com.zhxh.imms.order.entity.ScheduleOrder;
import com.zhxh.imms.order.vo.RequirementOrderVO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

@Component("scheduleOrderLogic")
public class ScheduleOrderLogic {
    @Resource(name = "scheduleOrderDAO")
    private ScheduleOrderDAO scheduleOrderDAO;

    @Resource(name = "requirementOrderLogic")
    private RequirementOrderLogic requirementOrderLogic;

    @Resource(name="productionOrderLogic")
    private ProductionOrderLogic productionOrderLogic;

    public ScheduleOrderLogic() {
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public String issue(RequirementOrderVO requirementOrderVO, ScheduleOrder scheduleOrder) {
        //1.保存ScheduleOrder
        this.scheduleOrderDAO.insert(scheduleOrder);
        //2.保存需求订单
        RequirementOrder requirementOrder = this.requirementOrderLogic.createFromVo (requirementOrderVO);
        //3.创建生产订单
        ProductionOrder productionOrder = this.productionOrderLogic.createProductionOrder(requirementOrder,scheduleOrder);
        //4.通知可视化进行数据更新
        this.publishEvent(EventType.ISSUE_REQUIREMENT_ORDER, requirementOrderVO.getRequirementOrderNo());
        //5.返回生产订单的单号
        return productionOrder.getProductionOrderNo();
    }

    public void publishEvent(String eventId, Object data) {

    }



}
