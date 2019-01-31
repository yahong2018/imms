package com.zhxh.imms.routing.service;

import com.zhxh.imms.routing.dao.OperationRoutingDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("operationRoutingService")
public class OperationRoutingService {
    @Resource(name="operationRoutingDAO")
    private OperationRoutingDAO operationRoutingDAO;
}
