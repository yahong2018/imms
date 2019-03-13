package com.zhxh.imms.routing.service;

import com.zhxh.imms.routing.dao.OperationRoutingOrderDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("operationRoutingOrderService")
public class OperationRoutingOrderService {
    @Resource(name="operationRoutingOrderDAO")
    private OperationRoutingOrderDAO operationRoutingOrderDAO;
}
