package com.zhxh.imms.order.logic;

import com.zhxh.imms.material.entity.BomOrder;
import com.zhxh.imms.material.logic.BomOrderLogic;
import com.zhxh.imms.order.entity.ProductionOrder;
import com.zhxh.imms.order.entity.RequirementOrder;
import com.zhxh.imms.order.entity.ScheduleOrder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import static com.zhxh.imms.material.entity.BomOrder.MANUFACTURE_BOM;

@Component("productionOrderLogic")
public class ProductionOrderLogic {
    @Resource(name = "bomOrderLogic")
    private BomOrderLogic bomOrderLogic;

    @Transactional(rollbackFor = RuntimeException.class)
    public ProductionOrder createProductionOrder(RequirementOrder requirementOrder, ScheduleOrder scheduleOrder) {
        //1.创建生产订单
        //2.创建尺码明细
        //3.创建量体数据
        //4.创建Bom单
        BomOrder bomOrder = this.bomOrderLogic.createBomOrder(MANUFACTURE_BOM);
        //5.创建生产订单物料清单
        //6.创建工艺路线

        return null;
    }

}
