package com.zhxh.imms.order.service;

import com.zhxh.core.data.DataCode.BCode;
import com.zhxh.core.env.SysEnv;
import com.zhxh.imms.material.dao.BomDAO;
import com.zhxh.imms.material.service.BomOrderService;
import com.zhxh.imms.material.vo.BomVO;
import com.zhxh.imms.order.dao.OrderMeasureDAO;
import com.zhxh.imms.order.dao.OrderSizeDAO;
import com.zhxh.imms.order.dao.ProductionOrderDAO;
import com.zhxh.imms.order.entity.ProductionOrder;
import com.zhxh.imms.order.entity.ScheduleOrder;
import com.zhxh.imms.routing.dao.OperationRoutingDAO;
import com.zhxh.imms.routing.dao.OperationRoutingOrderDAO;
import com.zhxh.imms.routing.entity.OperationRouting;
import com.zhxh.imms.routing.entity.OperationRoutingOrder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.zhxh.core.exception.ErrorCode.ERROR_UNKNOWN_EXCEPTION;
import static com.zhxh.core.exception.ExceptionHelper.throwException;

@Component("productionOrderService")
public class ProductionOrderService {
    public List<BomVO> getProductionOrderBom(ProductionOrder productionOrder){
        Map parameters = new HashMap<>();
        parameters.put("bomOrderId",productionOrder.getBomOrderId());
        return bomDAO.getByWhere(BomVO.class,"bom_order_id=#{bomOrderId}",parameters);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public ProductionOrder createProductionOrder(ScheduleOrder scheduleOrder) {
        //1.创建单头
        ProductionOrder productionOrder = createOrderHeader(scheduleOrder);
        //2.保存尺码明细
        productionOrderDAO.createOrderSizeFromSchedule(scheduleOrder, productionOrder);
        //3.保存量体数据
        productionOrderDAO.createMeasureDataFromSchedule(scheduleOrder, productionOrder);
        //4.创建生产订单物料清单
        productionOrderDAO.createBomFromSchedule(scheduleOrder, productionOrder);

        //5.如果是仿真环境，则自动创建工艺路线
        if (SysEnv.getEnvironmentMode() == SysEnv.ENVIRONMENT_MODE_SIMULATE) {
            this.createProductionOrderRouting(productionOrder);
        }

        //返回结果
        return productionOrder;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void createProductionOrderRouting(ProductionOrder productionOrder) {
        OperationRoutingOrder materialOperationRoutingOrder = createOperationRoutingOrderHeader(productionOrder);
        long operationRoutingOrderId = materialOperationRoutingOrder.getRecordId();
        List<OperationRouting> routingList = operationRoutingDAO.getByOperationRoutingOrderId(materialOperationRoutingOrder.getRecordId());
        if (routingList.size() == 0) {
            throwException(ERROR_UNKNOWN_EXCEPTION, String.format("工艺路线单%s还没有建工艺路线", materialOperationRoutingOrder.getRecordId()));
        }

        OperationRouting cuttingOperationRouting = operationRoutingDAO.getCuttingOperationRouting();
        cuttingOperationRouting.setPreRoutingId(0L);
        cuttingOperationRouting.setPreOperationId(0L);
        this.saveOperationRouting(cuttingOperationRouting, operationRoutingOrderId);

        OperationRouting nextRouting = routingList.stream().filter(x -> x.getPreRoutingId() == 0).findFirst().get();
        nextRouting.setPreRoutingId(cuttingOperationRouting.getRecordId());
        nextRouting.setPreOperationId(cuttingOperationRouting.getOperationId());

        for (OperationRouting theOperationRouting : routingList) {
            long oldId = theOperationRouting.getRecordId();
            this.saveOperationRouting(theOperationRouting, operationRoutingOrderId);

            Long currentId = theOperationRouting.getRecordId();
            Optional<OperationRouting> next = routingList.stream().filter(x -> x.getPreRoutingId().equals(oldId)).findAny();
            if (next.isPresent()) {
                next.get().setPreRoutingId(currentId);
            }
        }
    }

    private void saveOperationRouting(OperationRouting operationRouting, Long routingOrderId) {
        operationRouting.setOperationRoutingStatus(BCode.OPERATION_ROUTING_STATUS_PLANNED);
        operationRouting.setOperationRoutingOrderId(routingOrderId);
        operationRouting.setCompleteQty(0);
        operationRouting.setScrapQty(0);
        operationRoutingDAO.insert(operationRouting);
    }

    private OperationRoutingOrder createOperationRoutingOrderHeader(ProductionOrder productionOrder) {
        OperationRoutingOrder materialOperationRoutingOrder = operationRoutingOrderDAO.getByRefId(productionOrder.getFgMaterialId());
        if (materialOperationRoutingOrder == null) {
            throwException(ERROR_UNKNOWN_EXCEPTION, String.format("物料%s没有建立工艺路线单", productionOrder.getFgMaterialId()));
        }

        OperationRoutingOrder theOperationRoutingOrder = new OperationRoutingOrder();
        theOperationRoutingOrder.setRefId(productionOrder.getRecordId());
        theOperationRoutingOrder.setOperationRoutingType(BCode.OPERATION_ROUTING_ORDER_TYPE_PRODUCTION_ORDER);
        operationRoutingOrderDAO.insert(theOperationRoutingOrder);
        return materialOperationRoutingOrder;
    }

    private ProductionOrder createOrderHeader(ScheduleOrder scheduleOrder) {
        ProductionOrder productionOrder = new ProductionOrder();
        productionOrder.setProductionOrderStatus(BCode.ORDER_STATUS_PLANNED);
        this.fillFromScheduleOrder(scheduleOrder, productionOrder);
        productionOrderDAO.insert(productionOrder);
        return productionOrder;
    }

    private void fillFromScheduleOrder(ScheduleOrder scheduleOrder, ProductionOrder productionOrder) {
        productionOrder.setPriority(scheduleOrder.getPriority());
        productionOrder.setRequirementOrderId(scheduleOrder.getRecordId());
        productionOrder.setWorkCenterId(scheduleOrder.getWorkCenterId());
        productionOrder.setPlantId(scheduleOrder.getPlantId());
        productionOrder.setFgMaterialId(scheduleOrder.getFgMaterialId());
        productionOrder.setPlannedQty(scheduleOrder.getQtyPlanned());
        productionOrder.setPlannedStartDate(scheduleOrder.getDatePlannedStart());
        productionOrder.setPlannedEndDate(scheduleOrder.getDatePlannedEnd());
    }

    @Resource(name = "bomOrderService")
    private BomOrderService bomOrderService;

    @Resource(name = "productionOrderDAO")
    private ProductionOrderDAO productionOrderDAO;

    @Resource(name = "orderSizeDAO")
    private OrderSizeDAO orderSizeDAO;

    @Resource(name = "orderMeasureDAO")
    private OrderMeasureDAO orderMeasureDAO;

    @Resource(name = "bomDAO")
    private BomDAO bomDAO;

    @Resource(name = "operationRoutingOrderDAO")
    private OperationRoutingOrderDAO operationRoutingOrderDAO;

    @Resource(name = "operationRoutingDAO")
    private OperationRoutingDAO operationRoutingDAO;
}
