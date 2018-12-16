package com.zhxh.imms.routing.controller;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.web.SimpleCRUDController;
import com.zhxh.imms.routing.dao.OperationDAO;
import com.zhxh.imms.routing.entity.Operation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/imms/routing/operation")
public class OperationController extends SimpleCRUDController<Operation> {
    @Resource(name="operationDAO")
    private OperationDAO operationDAO;

    @Override
    protected BaseDAOWithEntity<Operation> getCrudDao() {
        return this.operationDAO;
    }
}
