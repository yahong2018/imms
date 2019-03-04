package com.zhxh.imms.order.dao;

import com.zhxh.admin.service.AuthenticateService;
import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.data.DataCode.BCode;
import com.zhxh.imms.code.service.CodeSeedService;
import com.zhxh.imms.material.dao.BomDAO;
import com.zhxh.imms.material.entity.BomOrder;
import com.zhxh.imms.material.service.BomOrderService;
import com.zhxh.imms.material.vo.BomVO;
import com.zhxh.imms.order.entity.MaterialPickingSchedule;
import com.zhxh.imms.order.entity.ProductionOrder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("productionOrderDAO")
public class ProductionOrderDAO  extends BaseDAOWithEntity<ProductionOrder> {
    @Resource(name="codeSeedService")
    private CodeSeedService codeSeedService;

    @Resource(name="bomOrderService")
    private BomOrderService bomOrderService;

    @Resource(name="materialPickingScheduleDAO")
    private MaterialPickingScheduleDAO materialPickingScheduleDAO;

    @Resource(name = "bomDAO")
    private BomDAO bomDAO;

    @Override
    protected int doInsert(ProductionOrder item) {
        String productionOrderNo = codeSeedService.createCode("productionOrderNo");
        item.setProductionOrderNo(productionOrderNo);

        return super.doInsert(item);
    }

    public List<BomVO> getProductionOrderBom(ProductionOrder productionOrder) {
        Map parameters = new HashMap<>();
        parameters.put("bomOrderId", productionOrder.getBomOrderId());
        return bomDAO.getByWhere(BomVO.class, "bom_order_id=#{bomOrderId}", parameters);
    }

    public MaterialPickingSchedule createProductionOrderMaterialPickingOrder(ProductionOrder productionOrder){
        int qtyPlanned = productionOrder.getPlannedQty();

        MaterialPickingSchedule materialPickingSchedule = new MaterialPickingSchedule();
        materialPickingSchedule.setProductionOrderId(productionOrder.getRecordId());
        materialPickingSchedule.setMaterialPickingOrderStatus(BCode.ORDER_STATUS_PLANNED);
        materialPickingSchedule.setPlannedPickingDate(productionOrder.getPlannedStartDate());
        materialPickingScheduleDAO.insert(materialPickingSchedule);

        Map parameter = new HashMap<>();
        parameter.put("pickingOrderBomOrderId", materialPickingSchedule.getRecordId());
        parameter.put("createBy", AuthenticateService.getCurrentLogin().getRecordId());
        parameter.put("qtyPlanned",qtyPlanned);
        parameter.put("productionOrderBomOrderId",productionOrder.getBomOrderId());
        parameter.put("materialTypeId",BCode.MATERIAL_TYPE_PART);

        super.executeByIdentifiedQuery(INSERT_CREATE_PRODUCTION_ORDER_PICKING_ORDER_BOM,parameter);

        return materialPickingSchedule;
    }

    public int createProductionOrderBom(ProductionOrder productionOrder){
        BomOrder bomOrder = bomOrderService.createBomOrder(BCode.BOM_TYPE_MANUFACTURE);
        Map parameter = new HashMap<>();
        parameter.put("bomOrderId",bomOrder.getRecordId());
        parameter.put("scheduleOrderId",productionOrder.getScheduleOrderId());
        int result = super.executeByIdentifiedQuery(INSERT_COPY_PRODUCTION_ORDER_BOM_FROM_SCHEDULE_ORDER,parameter);
        productionOrder.setBomOrderId(bomOrder.getRecordId());
        return result;
    }

    public int createProductionOrderOrderSize(ProductionOrder productionOrder){
        return copyFromSchedule(INSERT_COPY_ORDER_SIZE_FROM_SCHEDULE_ORDER,productionOrder);
    }

    public int createProductionOrderMeasureData(ProductionOrder productionOrder){
        return copyFromSchedule(INSERT_COPY_MEASURE_DATA_FROM_SCHEDULE_ORDER,productionOrder);
    }

    private int copyFromSchedule(String sqlIdentity,ProductionOrder productionOrder){
        Map parameter = new HashMap<>();
        parameter.put("productionOrderId",productionOrder.getRecordId());
        parameter.put("refRecordTypeProductionOrder", BCode.RECORD_TYPE_PRODUCTION_ORDER);
        parameter.put("createBy", AuthenticateService.getCurrentLogin().getRecordId());
        parameter.put("scheduleOrderId",productionOrder.getScheduleOrderId());
        parameter.put("refRecordTypeScheduleOrder",BCode.RECORD_TYPE_SCHEDULE_ORDER);

        return super.executeByIdentifiedQuery(sqlIdentity,parameter);
    }

    private final static String INSERT_CREATE_PRODUCTION_ORDER_PICKING_ORDER_BOM = "INSERT_CREATE_PRODUCTION_ORDER_PICKING_ORDER_BOM";

    private final static String INSERT_COPY_MEASURE_DATA_FROM_SCHEDULE_ORDER = "INSERT_COPY_MEASURE_DATA_FROM_SCHEDULE_ORDER";
    private final static String INSERT_COPY_ORDER_SIZE_FROM_SCHEDULE_ORDER = "INSERT_COPY_ORDER_SIZE_FROM_SCHEDULE_ORDER";
    private final static String INSERT_COPY_PRODUCTION_ORDER_BOM_FROM_SCHEDULE_ORDER = "INSERT_COPY_PRODUCTION_ORDER_BOM_FROM_SCHEDULE_ORDER";
}
