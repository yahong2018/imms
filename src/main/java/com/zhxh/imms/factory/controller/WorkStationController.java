package com.zhxh.imms.factory.controller;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.web.SimpleCRUDController;
import com.zhxh.imms.factory.dao.WorkStationDAO;
import com.zhxh.imms.factory.entity.WorkStation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/imms/factory/workStation")
public class WorkStationController extends SimpleCRUDController<WorkStation> {
    @Resource(name="workStationDAO")
    private WorkStationDAO workStationDAO;


    @Override
    protected BaseDAOWithEntity<WorkStation> getCrudDao() {
        return workStationDAO;
    }
}
