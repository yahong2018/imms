package com.zhxh.imms.code.controller;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.web.SimpleCRUDController;
import com.zhxh.imms.code.dao.MaterialTypeDAO;
import com.zhxh.imms.code.entity.MaterialType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/imms/code/materialType")
public class MaterialTypeController extends SimpleCRUDController<MaterialType> {
    @Resource(name="materialTypeDAO")
    private MaterialTypeDAO materialTypeDAO;

    @Override
    protected BaseDAOWithEntity<MaterialType> getCrudDao() {
        return this.materialTypeDAO;
    }
}
