package com.zhxh.imms.routing.controller;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.web.SimpleCRUDController;
import com.zhxh.imms.routing.dao.OperationMediaDAO;
import com.zhxh.imms.routing.entity.OperationMedia;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/imms/routing/operationMedia")
public class OperationMediaController extends SimpleCRUDController<OperationMedia> {
    @Resource(name="operationMedia")
    private OperationMediaDAO operationMediaDAO;

    @Override
    protected BaseDAOWithEntity<OperationMedia> getCrudDao() {
        return this.operationMediaDAO;
    }
}
