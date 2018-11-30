package com.zhxh.imms.material.controller;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.web.SimpleCRUDController;
import com.zhxh.imms.material.dao.MaterialDAO;
import com.zhxh.imms.material.entity.Material;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/imms/material/material")
public class MaterialController extends SimpleCRUDController<Material> {
    @Resource(name = "materialDAO")
    private MaterialDAO materialDAO;

    @Override
    protected BaseDAOWithEntity<Material> getCrudDao() {
        return this.materialDAO;
    }


    @Override
    protected List<Material> internalGetAll() {
        //转为MaterialVO

        return super.internalGetAll();
    }
}
