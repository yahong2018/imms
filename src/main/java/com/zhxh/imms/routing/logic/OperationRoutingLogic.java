package com.zhxh.imms.routing.logic;

import com.zhxh.imms.routing.dao.OperationRoutingDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("operationRoutingLogic")
public class OperationRoutingLogic {
    @Resource(name="operationRoutingDAO")
    private OperationRoutingDAO operationRoutingDAO;
}
