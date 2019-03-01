package com.zhxh.imms.bus;

import com.zhxh.core.GlobalConstants;
import com.zhxh.core.data.event.DataUpdateConsumer;
import com.zhxh.core.data.event.DataUpdateEvent;
import com.zhxh.core.web.ApiCallResult;
import com.zhxh.imms.bus.dto.CuttingOrderTechDTO;
import com.zhxh.imms.bus.dto.OperationRoutingOrderDTO;
import com.zhxh.imms.material.vo.BomVO;
import com.zhxh.imms.order.entity.ProductionOrder;
import com.zhxh.imms.order.service.ProductionOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
        if(event.getDataOperationType()!= GlobalConstants.DATA_OPERATION_INSERT){
            return;
        }
        ProductionOrder productionOrder = (ProductionOrder) event.getItem();
        if(productionOrder==null){
            return;
        }
        List<BomVO> boms = productionOrderService.getProductionOrderBom(productionOrder);
        //
        //TODO: 搬迁 ProductionOrderIssueMessageService
        //
    }

    @RequestMapping("onOperationRoutingReady.handler")
    @ResponseBody
    public ApiCallResult onOperationRoutingReady(OperationRoutingOrderDTO dto){
        //TODO:搬迁Itf207ServiceImpl
        return null;
    }

    @RequestMapping("onCuttingTechReady.handler")
    @ResponseBody
    public ApiCallResult onCuttingTechReady(CuttingOrderTechDTO dto){
        //TODO:搬迁Itf301ServiceImpl
        return null;
    }

    @Resource(name="productionOrderService")
    private ProductionOrderService productionOrderService;
}
