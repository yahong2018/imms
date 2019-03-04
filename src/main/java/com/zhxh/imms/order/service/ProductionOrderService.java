package com.zhxh.imms.order.service;

import com.zhxh.core.data.DataCode.BCode;
import com.zhxh.core.env.SysEnv;
import com.zhxh.imms.order.dao.OrderMeasureDAO;
import com.zhxh.imms.order.dao.OrderSizeDAO;
import com.zhxh.imms.order.dao.ProductionOrderDAO;
import com.zhxh.imms.order.entity.MaterialPickingSchedule;
import com.zhxh.imms.order.entity.ProductionOrder;
import com.zhxh.imms.order.entity.ScheduleOrder;
import com.zhxh.imms.routing.dao.OperationRoutingDAO;
import com.zhxh.imms.routing.dao.OperationRoutingOrderDAO;
import com.zhxh.imms.routing.entity.OperationRouting;
import com.zhxh.imms.routing.entity.OperationRoutingOrder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

import static com.zhxh.core.exception.ErrorCode.ERROR_UNKNOWN_EXCEPTION;
import static com.zhxh.core.exception.ExceptionHelper.throwException;

@Component("productionOrderService")
public class ProductionOrderService {
    //
    // 创建生产计划所需的领料计划
    //
    @Transactional(rollbackFor = RuntimeException.class)
    public MaterialPickingSchedule createProductionOrderPickingOrder(ProductionOrder productionOrder) {
        if (productionOrder.getProductionOrderStatus() != BCode.ORDER_STATUS_RELEASED) {
            //
            //必须是已经下达的任务才可以开始领料：
            //   1.  裁剪技术文件已准备好    2.工艺路线已准备好   3.Bom已准备好（个人认为其实就是物料已经准备好了）
            //
            return null;
        }
        //
        //TODO:注意目前只支持单层Bom，不支持多层BOM。
        //
        return productionOrderDAO.createProductionOrderMaterialPickingOrder(productionOrder);
    }

    //
    // 根据生产排程创建生产计划
    //
    @Transactional(rollbackFor = RuntimeException.class)
    public ProductionOrder createProductionOrder(ScheduleOrder scheduleOrder) {
        //1.创建单头
        ProductionOrder productionOrder = createOrderHeader(scheduleOrder);
        //2.保存尺码明细
        productionOrderDAO.createProductionOrderOrderSize( productionOrder);
        //3.保存量体数据
        productionOrderDAO.createProductionOrderMeasureData( productionOrder);
        //4.创建生产订单物料清单
        productionOrderDAO.createProductionOrderBom( productionOrder);

        //5.如果是仿真环境，则自动创建工艺路线
        if (SysEnv.getEnvironmentMode() == SysEnv.ENVIRONMENT_MODE_SIMULATE) {
            this.createProductionOrderRouting(productionOrder);
        }

        //返回结果
        return productionOrder;
    }

    //
    // 创建生产计划的工艺路线
    //
    @Transactional(rollbackFor = RuntimeException.class)
    public OperationRoutingOrder createProductionOrderRouting(ProductionOrder productionOrder) {
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

        return materialOperationRoutingOrder;
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
        productionOrder.setScheduleOrderId(scheduleOrder.getRecordId());
        productionOrder.setPriority(scheduleOrder.getPriority());
        productionOrder.setRequirementOrderId(scheduleOrder.getRecordId());
        productionOrder.setWorkCenterId(scheduleOrder.getWorkCenterId());
        productionOrder.setPlantId(scheduleOrder.getPlantId());
        productionOrder.setFgMaterialId(scheduleOrder.getFgMaterialId());
        productionOrder.setPlannedQty(scheduleOrder.getQtyPlanned());
        productionOrder.setPlannedStartDate(scheduleOrder.getDatePlannedStart());
        productionOrder.setPlannedEndDate(scheduleOrder.getDatePlannedEnd());
    }


    @Resource(name = "productionOrderDAO")
    private ProductionOrderDAO productionOrderDAO;

    @Resource(name = "orderSizeDAO")
    private OrderSizeDAO orderSizeDAO;

    @Resource(name = "orderMeasureDAO")
    private OrderMeasureDAO orderMeasureDAO;



    @Resource(name = "operationRoutingOrderDAO")
    private OperationRoutingOrderDAO operationRoutingOrderDAO;

    @Resource(name = "operationRoutingDAO")
    private OperationRoutingDAO operationRoutingDAO;


}
