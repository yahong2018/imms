package com.zhxh.imms.material.controller;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.web.SimpleCRUDController;
import com.zhxh.imms.material.dao.BomDAO;
import com.zhxh.imms.material.entity.Bom;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/imms/material/bom")
public class BomController extends SimpleCRUDController<Bom> {
    @Resource(name="bomDAO")
    private BomDAO bomDAO;

    @Override
    protected BaseDAOWithEntity<Bom> getCrudDao() {
        return this.bomDAO;
    }

    @Override
    protected List<Bom> internalGetAll() {
        //要返回的是BomVO，而不是Bom。要在mapper文件里面定义查询

        return super.internalGetAll();
    }
}
