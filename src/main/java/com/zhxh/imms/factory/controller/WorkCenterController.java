package com.zhxh.imms.factory.controller;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.web.SimpleCRUDController;
import com.zhxh.imms.factory.dao.WorkCenterDAO;
import com.zhxh.imms.factory.entity.WorkCenter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/imms/factory/workCenter")
public class WorkCenterController extends SimpleCRUDController<WorkCenter> {
    @Resource(name="workCenterDAO")
    private WorkCenterDAO workCenterDAO;

    @Override
    protected BaseDAOWithEntity<WorkCenter> getCrudDao() {
        return workCenterDAO;
    }
}
