package com.zhxh.imms.factory.controller;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.web.SimpleCRUDController;
import com.zhxh.imms.factory.dao.OperatorDAO;
import com.zhxh.imms.factory.entity.Operator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/imms/factory/operator")
public class OperatorController extends SimpleCRUDController<Operator> {
    @Resource(name="operatorDAO")
    private OperatorDAO operatorDAO;

    @Override
    protected BaseDAOWithEntity<Operator> getCrudDao() {
        return operatorDAO;
    }
}
