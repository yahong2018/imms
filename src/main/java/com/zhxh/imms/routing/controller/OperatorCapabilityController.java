package com.zhxh.imms.routing.controller;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.web.SimpleCRUDController;
import com.zhxh.imms.routing.dao.OperatorCapabilityDAO;
import com.zhxh.imms.routing.entity.OperatorCapability;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/imms/routing/operatorCapability")
public class OperatorCapabilityController extends SimpleCRUDController<OperatorCapability> {
    @Resource(name="operatorCapability")
    private OperatorCapabilityDAO operatorCapabilityDAO;

    @Override
    protected BaseDAOWithEntity<OperatorCapability> getCrudDao() {
        return this.operatorCapabilityDAO;
    }
}
