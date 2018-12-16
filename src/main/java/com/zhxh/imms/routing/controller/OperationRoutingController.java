package com.zhxh.imms.routing.controller;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.web.SimpleCRUDController;
import com.zhxh.imms.routing.dao.OperationRoutingDAO;
import com.zhxh.imms.routing.entity.OperationRouting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/imms/routing/operationRouting")
public class OperationRoutingController extends SimpleCRUDController<OperationRouting> {
    @Resource(name="operationRouting")
    private OperationRoutingDAO operationRoutingDAO;

    @Override
    protected BaseDAOWithEntity<OperationRouting> getCrudDao() {
        return this.operationRoutingDAO;
    }
}
