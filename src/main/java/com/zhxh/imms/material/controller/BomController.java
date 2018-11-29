package com.zhxh.imms.material.controller;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.web.SimpleCRUDController;
import com.zhxh.imms.material.dao.BomDAO;
import com.zhxh.imms.material.entity.Bom;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class BomController extends SimpleCRUDController<Bom> {
    @Resource(name="bomDAO")
    private BomDAO bomDAO;

    @Override
    protected BaseDAOWithEntity<Bom> getCrudDao() {
        return this.bomDAO;
    }
}