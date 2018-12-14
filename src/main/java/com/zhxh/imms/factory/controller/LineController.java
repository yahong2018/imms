package com.zhxh.imms.factory.controller;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.web.SimpleCRUDController;
import com.zhxh.imms.factory.dao.LineDAO;
import com.zhxh.imms.factory.entity.Line;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/imms/factory/line")
public class LineController extends SimpleCRUDController<Line> {
    @Resource(name = "lineDAO")
    private LineDAO lineDAO;

    @Override
    protected BaseDAOWithEntity<Line> getCrudDao() {
        return lineDAO;
    }
}
