package com.zhxh.imms.order.controller;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.web.SimpleCRUDController;
import com.zhxh.imms.order.dao.RequirementOrderDAO;
import com.zhxh.imms.order.entity.RequirementOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/imms/mes/ro/requirementOrder")
public class RequirementOrderController extends SimpleCRUDController<RequirementOrder> {
    @Resource(name="requirementOrderDAO")
    private RequirementOrderDAO requirementOrderDAO;

    @Override
    protected BaseDAOWithEntity<RequirementOrder> getCrudDao() {
        return this.requirementOrderDAO;
    }

}
