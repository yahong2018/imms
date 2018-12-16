package com.zhxh.imms.routing.controller;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.web.SimpleCRUDController;
import com.zhxh.imms.routing.dao.OperationRoutingOrderDAO;
import com.zhxh.imms.routing.entity.OperationRoutingOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/imms/routing/operationRoutingOrder")
public class OperationRoutingOrderController extends SimpleCRUDController<OperationRoutingOrder> {
    @Resource(name="operationRoutingOrder")
    private OperationRoutingOrderDAO operationRoutingOrderDAO;

    @Override
    protected BaseDAOWithEntity<OperationRoutingOrder> getCrudDao() {
        return this.operationRoutingOrderDAO;
    }
}
