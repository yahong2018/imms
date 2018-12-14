package com.zhxh.imms.factory.controller;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.web.SimpleCRUDController;
import com.zhxh.imms.factory.dao.PlantDAO;
import com.zhxh.imms.factory.entity.Plant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/imms/factory/plant")
public class PlantController extends SimpleCRUDController<Plant> {
    @Resource(name="plantDAO")
    private PlantDAO plantDAO;

    @Override
    protected BaseDAOWithEntity<Plant> getCrudDao() {
        return plantDAO;
    }
}
