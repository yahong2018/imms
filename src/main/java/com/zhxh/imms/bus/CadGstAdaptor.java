package com.zhxh.imms.bus;

import com.alibaba.fastjson.JSON;
import com.zhxh.core.GlobalConstants;
import com.zhxh.core.data.DataCode.BCode;
import com.zhxh.core.data.event.DataUpdateConsumer;
import com.zhxh.core.data.event.DataUpdateEvent;
import com.zhxh.core.exception.BusinessException;
import com.zhxh.core.web.ApiCallResult;
import com.zhxh.imms.bus.dto.OperationRoutingDTO;
import com.zhxh.imms.bus.dto.OperationRoutingOrderDTO;
import com.zhxh.imms.code.dao.MachineTypeDAO;
import com.zhxh.imms.code.entity.MachineType;
import com.zhxh.imms.material.dao.MaterialDAO;
import com.zhxh.imms.material.entity.Material;
import com.zhxh.imms.material.vo.BomVO;
import com.zhxh.imms.order.dao.ProductionOrderDAO;
import com.zhxh.imms.order.entity.ProductionOrder;
import com.zhxh.imms.routing.dao.OperationDAO;
import com.zhxh.imms.routing.dao.OperationRoutingDAO;
import com.zhxh.imms.routing.dao.OperationRoutingOrderDAO;
import com.zhxh.imms.routing.entity.Operation;
import com.zhxh.imms.routing.entity.OperationRouting;
import com.zhxh.imms.routing.entity.OperationRoutingOrder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.zhxh.core.exception.ErrorCode.ERROR_DATA_NOT_EXISTS;
import static com.zhxh.core.exception.ExceptionHelper.throwException;

@Controller
@RequestMapping("/bus")
public class CadGstAdaptor implements DataUpdateConsumer {


    @Override
    public List<String> getSubscribeTable() {
        List<String> result = new ArrayList<>();
        result.add(ProductionOrder.class.getCanonicalName());

        return result;
    }

    @Override
    public void consume(DataUpdateEvent event) {
        //
        //只有新建的生产计划才需要通知给Cad和Gst.
        // 题外话：
        // 1.如果Cad或者GST的工艺弄错了，有修改，怎么处理？
        //  系统检测到有修改，然后就停止继续执行相关单据，由管理人员手工处理是否继续。
        // 2.productionOrder的新建，必须指定bom、measure、size，也就是必须要先有schedule order（requirement order），否则不能新建。
        //
        if (event.getDataOperationType() != GlobalConstants.DATA_OPERATION_INSERT) {
            return;
        }
        ProductionOrder productionOrder = (ProductionOrder) event.getItem();
        if (productionOrder == null) {
            return;
        }
        List<BomVO> boms = productionOrderDAO.getProductionOrderBom(productionOrder);
        //
        //TODO: 搬迁 ProductionOrderIssueMessageService
        //
    }

    @RequestMapping("onOperationRoutingReady.handler")
    @ResponseBody
    @Transactional(rollbackFor = BusinessException.class)
    public ApiCallResult onOperationRoutingReady(BusMessage busMessage) {
        //
        //TODO:搬迁Itf207ServiceImpl
        //
        try {
            this.busMessageDAO.insert(busMessage);
        } catch (BusinessException e) {
            return ApiCallResult.ERROR(e.getMessage());
        }

        OperationRoutingOrderDTO dto = JSON.parseObject(busMessage.getMessageBody(), OperationRoutingOrderDTO.class);
        ProductionOrder productionOrder = productionOrderDAO.getOneByProperty("productionOrderNo", dto.getProductionOrderNo());
        if (productionOrder == null) {
            String idLabel = productionOrderDAO.getIdLabel();
            throwException(ERROR_DATA_NOT_EXISTS, idLabel, dto.getProductionOrderNo());
        }

        OperationRoutingOrder operationRoutingOrder = this.verifyRoutingOrder(dto);
        if (!operationRoutingOrder.getRefId().equals(productionOrder.getFgMaterialId())) {
            throwException(ERROR_DATA_NOT_EXISTS, "生产订单[" + productionOrder.getProductionOrderNo() + "]的主面料和工艺路线的物料[" + dto.getMaterialNo() + "]不相等！");
        }

        operationRoutingOrderDAO.insert(operationRoutingOrder);
        for(int i=0;i<dto.getOperationRoutings().length;i++){
            OperationRoutingDTO operationRoutingDTO = dto.getOperationRoutings()[i];
            OperationRouting operationRouting = this.verifyRouting(operationRoutingDTO);
            operationRouting.setOperationRoutingOrderId(operationRoutingOrder.getRecordId());
            operationRouting.setOperationRoutingStatus(BCode.OPERATION_ROUTING_STATUS_PLANNED);

            operationRoutingDAO.insert(operationRouting);
        }

        operationRoutingOrderDAO.buildOperationOrderPreRoutingId(operationRoutingOrder);

        productionOrder.setOperationRoutingOrderId(operationRoutingOrder.getRecordId());
        productionOrderDAO.update(productionOrder);

        return ApiCallResult.DEFAULT;
    }

    @RequestMapping("onCuttingTechReady.handler")
    @ResponseBody
    public ApiCallResult onCuttingTechReady(BusMessage busMessage) {
        //TODO:搬迁Itf301ServiceImpl
        try {
            this.busMessageDAO.insert(busMessage);
        } catch (BusinessException e) {
            return ApiCallResult.ERROR(e.getMessage());
        }


        return null;
    }


    private OperationRoutingOrder verifyRoutingOrder(OperationRoutingOrderDTO dto) {
        OperationRoutingOrder model = new OperationRoutingOrder();
        model.setOperationRoutingType(BCode.OPERATION_ROUTING_ORDER_TYPE_PRODUCTION_ORDER);
        Material material = materialDAO.getOneByProperty("materialNo", dto.getMaterialNo());
        if (material == null) {
            String idLabel = materialDAO.getPropertyLabel("materialNo");
            throwException(ERROR_DATA_NOT_EXISTS, idLabel, dto.getMaterialNo());
        }
        model.setRefId(material.getRecordId());

        return model;
    }


    private OperationRouting verifyRouting(OperationRoutingDTO dto) {
        Operation operation = operationDAO.getOneByProperty("operationNo", dto.getOperationNo());
        if (operation == null) {
            String idLabel = operationDAO.getPropertyLabel("operationNo");
            throwException(ERROR_DATA_NOT_EXISTS, idLabel, dto.getOperationNo());
        }
        MachineType machineType = machineTypeDAO.getOneByProperty("machineTypeNo",dto.getMachineType());
        if(machineType==null){
            String idLabel = machineTypeDAO.getPropertyLabel("machineTypeNo");
            throwException(ERROR_DATA_NOT_EXISTS, idLabel, dto.getMachineType());
        }

        OperationRouting model = new OperationRouting();
        model.setIfOutsource(dto.getIfOutsource());
        model.setOperationId(operation.getRecordId());
        model.setStandardTime(dto.getStandardTime());
        model.setQaProcedure(dto.getQaProcedure());
        model.setStandardPrice(dto.getStandardPrice());
        model.setSectionType(dto.getSectionType());
        model.setMachineTypeId(machineType.getRecordId());
        model.setRequiredLevel(dto.getRequiredLevel());

        if(dto.getPreOperations()!=null && dto.getPreOperations().length>0){
            String preOperationNo = dto.getPreOperations()[0];
            Operation preOperation = operationDAO.getOneByProperty("operationNo", preOperationNo);
            if (preOperation == null) {
                String idLabel = operationDAO.getPropertyLabel("operationNo");
                throwException(ERROR_DATA_NOT_EXISTS, idLabel, preOperationNo);
            }
            model.setPreOperationId(preOperation.getRecordId());
        }

        return model;
    }

    @Resource(name = "productionOrderDAO")
    private ProductionOrderDAO productionOrderDAO;
    @Resource(name = "BusMessageDAO")
    private BusMessageDAO busMessageDAO;

    @Resource(name = "materialDAO")
    private MaterialDAO materialDAO;

    @Resource(name = "operationDAO")
    private OperationDAO operationDAO;

    @Resource(name="machineTypeDAO")
    private MachineTypeDAO machineTypeDAO;

    @Resource(name="operationRoutingOrderDAO")
    private OperationRoutingOrderDAO operationRoutingOrderDAO;

    @Resource(name="operationRoutingDAO")
    private OperationRoutingDAO operationRoutingDAO;

}
