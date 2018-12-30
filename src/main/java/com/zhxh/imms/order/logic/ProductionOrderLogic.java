package com.zhxh.imms.order.logic;

import com.zhxh.core.data.DataCode.BCode;
import com.zhxh.imms.material.entity.BomOrder;
import com.zhxh.imms.material.entity.BomOrderType;
import com.zhxh.imms.material.logic.BomOrderLogic;
import com.zhxh.imms.order.dao.ProductionOrderDAO;
import com.zhxh.imms.order.dao.ProductionOrderSizeDAO;
import com.zhxh.imms.order.entity.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component("productionOrderLogic")
public class ProductionOrderLogic {
    @Resource(name = "bomOrderLogic")
    private BomOrderLogic bomOrderLogic;

    @Resource(name = "productionOrderDAO")
    private ProductionOrderDAO productionOrderDAO;

    @Resource(name="productionOrderSizeDAO")
    private ProductionOrderSizeDAO productionOrderSizeDAO;

    @Transactional(rollbackFor = RuntimeException.class)
    public ProductionOrder createProductionOrder(RequirementOrder requirementOrder, ScheduleOrder scheduleOrder) {
        //1.创建Bom单
        BomOrder bomOrder = this.bomOrderLogic.createBomOrder(BomOrderType.MANUFACTURE);
        //2.创建生产订单
        ProductionOrder productionOrder = this.internalCreateProductionOrder(requirementOrder, scheduleOrder, bomOrder);

        //4.创建量体数据
        //5.创建生产订单物料清单
        //6.创建工艺路线

        return productionOrder;
    }

    private ProductionOrder internalCreateProductionOrder(RequirementOrder requirementOrder, ScheduleOrder scheduleOrder, BomOrder bomOrder) {
        //创建单头
        ProductionOrder productionOrder = createOrderHeader(requirementOrder, scheduleOrder, bomOrder);
        //保存尺码明细
        for (int i = 0; i < requirementOrder.getOrderSizes().length; i++) {
            ProductionOrderSize productionOrderSize = requirementOrder.getOrderSizes()[i];
            productionOrderSize.setProductionOrderId(productionOrder.getProductionOrderId());
            productionOrderSizeDAO.insert(productionOrderSize);
        }
        //保存量体数据

        return productionOrder;
    }

    private ProductionOrder createOrderHeader(RequirementOrder requirementOrder, ScheduleOrder scheduleOrder, BomOrder bomOrder) {
        ProductionOrder productionOrder = new ProductionOrder();
        this.fillFromRequirementOrder(requirementOrder, productionOrder);
        this.fillFromScheduleOrder(scheduleOrder, productionOrder);
        productionOrder.setProductionOrderStatus(BCode.ORDER_STATUS_PLANNED);
        productionOrder.setBomOrderId(bomOrder.getRecordId());
        productionOrderDAO.insert(productionOrder);
        return productionOrder;
    }

    private void fillFromRequirementOrder(RequirementOrder requirementOrder, ProductionOrder productionOrder) {
        productionOrder.setPriority(requirementOrder.getPriority());
        productionOrder.setRequirementOrderId(requirementOrder.getRecordId());
        productionOrder.setWorkCenterId(requirementOrder.getWorkCenterId());
        productionOrder.setPlantId(requirementOrder.getPlantId());
        productionOrder.setFgMaterialId(requirementOrder.getFgMaterialId());
    }

    private void fillFromScheduleOrder(ScheduleOrder scheduleOrder, ProductionOrder productionOrder) {
        productionOrder.setPlannedQty(scheduleOrder.getPlannedQty());
        productionOrder.setPlannedStartDate(scheduleOrder.getPlannedStartDate());
        productionOrder.setPlannedEndDate(scheduleOrder.getPlannedEndDate());
    }

}
