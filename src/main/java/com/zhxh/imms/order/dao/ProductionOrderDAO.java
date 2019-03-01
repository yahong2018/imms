package com.zhxh.imms.order.dao;

import com.zhxh.admin.service.AuthenticateService;
import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.data.DataCode.BCode;
import com.zhxh.imms.GlobalConstants;
import com.zhxh.imms.code.service.CodeSeedService;
import com.zhxh.imms.material.entity.BomOrder;
import com.zhxh.imms.material.service.BomOrderService;
import com.zhxh.imms.order.entity.ProductionOrder;
import com.zhxh.imms.order.entity.ScheduleOrder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Component("productionOrderDAO")
public class ProductionOrderDAO  extends BaseDAOWithEntity<ProductionOrder> {
    @Resource(name="codeSeedService")
    private CodeSeedService codeSeedService;

    @Resource(name="bomOrderService")
    private BomOrderService bomOrderService;

    @Override
    protected int doInsert(ProductionOrder item) {
        String productionOrderNo = codeSeedService.createCode("productionOrderNo");
        item.setProductionOrderNo(productionOrderNo);

        return super.doInsert(item);
    }

    public int createBomFromSchedule(ScheduleOrder scheduleOrder, ProductionOrder productionOrder){
        BomOrder bomOrder = bomOrderService.createBomOrder(BCode.BOM_TYPE_MANUFACTURE);
        Map parameter = new HashMap<>();
        parameter.put("bomOrderId",bomOrder.getRecordId());
        parameter.put("scheduleOrderId",scheduleOrder.getRecordId());
        int result = super.executeByIdentifiedQuery(INSERT_COPY_PRODUCTION_ORDER_BOM_FROM_SCHEDULE_ORDER,parameter);
        productionOrder.setBomOrderId(bomOrder.getRecordId());
        return result;
    }

    public int createOrderSizeFromSchedule(ScheduleOrder scheduleOrder, ProductionOrder productionOrder){
        return copyFromSchedule(INSERT_COPY_ORDER_SIZE_FROM_SCHEDULE_ORDER,scheduleOrder,productionOrder);
    }

    public int createMeasureDataFromSchedule(ScheduleOrder scheduleOrder, ProductionOrder productionOrder){
        return copyFromSchedule(INSERT_COPY_MEASURE_DATA_FROM_SCHEDULE_ORDER,scheduleOrder,productionOrder);
    }

    private int copyFromSchedule(String sqlIdentity,ScheduleOrder scheduleOrder, ProductionOrder productionOrder){
        Map parameter = new HashMap<>();
        parameter.put("productionOrderId",productionOrder.getRecordId());
        parameter.put("refRecordTypeProductionOrder", BCode.RECORD_TYPE_PRODUCTION_ORDER);
        parameter.put("createBy", AuthenticateService.getCurrentLogin().getRecordId());
        parameter.put("scheduleOrderId",scheduleOrder.getRecordId());
        parameter.put("refRecordTypeScheduleOrder",BCode.RECORD_TYPE_SCHEDULE_ORDER);

        return super.executeByIdentifiedQuery(sqlIdentity,parameter);
    }

    private final static String INSERT_COPY_MEASURE_DATA_FROM_SCHEDULE_ORDER = "INSERT_COPY_MEASURE_DATA_FROM_SCHEDULE_ORDER";
    private final static String INSERT_COPY_ORDER_SIZE_FROM_SCHEDULE_ORDER = "INSERT_COPY_ORDER_SIZE_FROM_SCHEDULE_ORDER";
    private final static String INSERT_COPY_PRODUCTION_ORDER_BOM_FROM_SCHEDULE_ORDER = "INSERT_COPY_PRODUCTION_ORDER_BOM_FROM_SCHEDULE_ORDER";
}
