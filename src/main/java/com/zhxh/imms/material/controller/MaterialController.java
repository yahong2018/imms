package com.zhxh.imms.material.controller;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.web.SimpleCRUDController;
import com.zhxh.imms.material.dao.MaterialDAO;
import com.zhxh.imms.material.entity.Material;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class MaterialController extends SimpleCRUDController<Material> {
    @Resource(name = "materialDAO")
    private MaterialDAO materialDAO;

    @Override
    protected BaseDAOWithEntity<Material> getCrudDao() {
        return this.materialDAO;
    }
}
