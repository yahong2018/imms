package com.zhxh.imms.material.controller;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.web.SimpleCRUDController;
import com.zhxh.imms.material.dao.MaterialMediaDAO;
import com.zhxh.imms.material.entity.MaterialMedia;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class MaterialMediaController extends SimpleCRUDController<MaterialMedia> {
    @Resource(name="materialMediaDAO")
    private MaterialMediaDAO materialMediaDAO;

    @Override
    protected BaseDAOWithEntity<MaterialMedia> getCrudDao() {
        return this.materialMediaDAO;
    }
}
