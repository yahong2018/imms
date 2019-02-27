package com.zhxh.imms.order.service;

import com.zhxh.core.data.DataCode.BCode;
import com.zhxh.imms.GlobalConstants;
import com.zhxh.imms.material.dao.BomDAO;
import com.zhxh.imms.material.entity.BomOrder;
import com.zhxh.imms.material.service.BomOrderService;
import com.zhxh.imms.material.vo.BomVO;
import com.zhxh.imms.order.dao.ProductionOrderDAO;
import com.zhxh.imms.order.dao.ProductionOrderMeasureDataDAO;
import com.zhxh.imms.order.dao.ProductionOrderSizeDAO;
import com.zhxh.imms.order.entity.*;
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
    @Resource(name = "bomOrderService")
    private BomOrderService bomOrderService;

    @Resource(name = "productionOrderDAO")
    private ProductionOrderDAO productionOrderDAO;

    @Resource(name = "productionOrderSizeDAO")
    private ProductionOrderSizeDAO productionOrderSizeDAO;

    @Resource(name = "productionOrderMeasureDataDAO")
    private ProductionOrderMeasureDataDAO productionOrderMeasureDataDAO;

    @Resource(name = "bomDAO")
    private BomDAO bomDAO;

    @Resource(name = "operationRoutingOrderDAO")
    private OperationRoutingOrderDAO operationRoutingOrderDAO;

    @Resource(name = "operationRoutingDAO")
    private OperationRoutingDAO operationRoutingDAO;

    @Transactional(rollbackFor = RuntimeException.class)
    public ProductionOrder createProductionOrder(RequirementOrder requirementOrder, ScheduleOrder scheduleOrder) {
        //1.创建单头
        ProductionOrder productionOrder = createOrderHeader(requirementOrder, scheduleOrder);
        //2.保存尺码明细
        saveSize(requirementOrder.getOrderSizeList(), productionOrder);
        //3.保存量体数据
        saveMeasureData(requirementOrder.getMeasureDataList(), productionOrder);
        //4.创建生产订单物料清单
        saveBom(requirementOrder.getBomList(), productionOrder);

        return productionOrder;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void createProductionOrderRouting(ProductionOrder productionOrder) {
        OperationRoutingOrder materialOperationRoutingOrder = createOperationRoutingOrderHeader(productionOrder);
        List<OperationRouting> routingList = operationRoutingDAO.getByOperationRoutingOrderId(materialOperationRoutingOrder.getRecordId());
        if (routingList.size() == 0) {
            throwException(ERROR_UNKNOWN_EXCEPTION, String.format("工艺路线单%s还没有建工艺路线", materialOperationRoutingOrder.getRecordId()));
        }

        OperationRouting cuttingOperationRouting = operationRoutingDAO.getCuttingOperationRouting();
        cuttingOperationRouting.setPreRoutingId(0L);
        cuttingOperationRouting.setPreOperationId(0L);
        this.saveOperationRouting(cuttingOperationRouting,materialOperationRoutingOrder.getRecordId());
        routingList.add(0, cuttingOperationRouting);
        OperationRouting nextRouting = routingList.stream().filter(x -> x.getPreRoutingId() == 0).findFirst().get();
        nextRouting.setPreRoutingId(cuttingOperationRouting.getRecordId());
        nextRouting.setPreOperationId(cuttingOperationRouting.getOperationId());

        for (int i = 1; i < routingList.size(); i++) {
            OperationRouting theOperationRouting = routingList.get(i);
            this.saveOperationRouting(theOperationRouting,materialOperationRoutingOrder.getRecordId());

            Long recordId = theOperationRouting.getRecordId();
            Optional<OperationRouting> next = routingList.stream().filter(x -> x.getPreRoutingId().equals(theOperationRouting.getRecordId())).findAny();
            if (next.isPresent()) {
                next.get().setPreRoutingId(recordId);
            }
        }
    }

    private void saveOperationRouting(OperationRouting operationRouting,Long routingOrderId){
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

    private void saveBom(BomVO[] bomList, ProductionOrder productionOrder) {
        BomOrder bomOrder = this.bomOrderService.createBomOrder(BCode.BOM_TYPE_MANUFACTURE, productionOrder.getRecordId());
        for (int i = 0; i < bomList.length; i++) {
            BomVO bomVO = bomList[i];
            bomVO.setBomOrderId(bomOrder.getRecordId());
            bomDAO.insert(bomVO);
        }
    }

    private void saveMeasureData(OrderMeasure[] measureDataList, ProductionOrder productionOrder) {
        for (int i = 0; i < measureDataList.length; i++) {
            OrderMeasure measureData = measureDataList[i];
            measureData.setOrderId(productionOrder.getRecordId());
            productionOrderMeasureDataDAO.insert(measureData);
        }
    }

    private void saveSize(OrderSize[] sizes, ProductionOrder productionOrder) {
        for (int i = 0; i < sizes.length; i++) {
            OrderSize productionOrderSize = sizes[i];
            productionOrderSize.setOrderId(productionOrder.getRecordId());
            productionOrderSize.setRefRecordType(GlobalConstants.RECORD_TYPE_PRODUCTION_ORDER);
            productionOrderSizeDAO.insert(productionOrderSize);
        }
    }

    private ProductionOrder createOrderHeader(RequirementOrder requirementOrder, ScheduleOrder scheduleOrder) {
        ProductionOrder productionOrder = new ProductionOrder();
        this.fillFromRequirementOrder(requirementOrder, productionOrder);
        this.fillFromScheduleOrder(scheduleOrder, productionOrder);
        productionOrder.setProductionOrderStatus(BCode.ORDER_STATUS_PLANNED);
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
        productionOrder.setPlannedQty(scheduleOrder.getQtyPlanned());
        productionOrder.setPlannedStartDate(scheduleOrder.getDatePlannedStart());
        productionOrder.setPlannedEndDate(scheduleOrder.getDatePlannedEnd());
    }

}
