package com.zhxh.imms.material.controller;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.web.SimpleCRUDController;
import com.zhxh.imms.material.dao.BomOrderDAO;
import com.zhxh.imms.material.entity.BomOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/imms/material/bomOrder")
public class BomOrderController extends SimpleCRUDController<BomOrder> {
    @Resource(name = "bomOrderDAO")
    private BomOrderDAO bomOrderDAO;

    @Override
    protected BaseDAOWithEntity<BomOrder> getCrudDao() {
        return this.bomOrderDAO;
    }


}
