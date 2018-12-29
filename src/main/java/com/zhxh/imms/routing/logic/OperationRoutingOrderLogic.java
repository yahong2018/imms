package com.zhxh.imms.routing.logic;

import com.zhxh.imms.routing.dao.OperationRoutingOrderDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("operationRoutingOrderLogic")
public class OperationRoutingOrderLogic {
    @Resource(name="operationRoutingOrderDAO")
    private OperationRoutingOrderDAO operationRoutingOrderDAO;

}
