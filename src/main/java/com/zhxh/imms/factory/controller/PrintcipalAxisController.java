package com.zhxh.imms.factory.controller;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.web.SimpleCRUDController;
import com.zhxh.imms.factory.dao.PrincipalAxisDAO;
import com.zhxh.imms.factory.entity.PrincipalAxis;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/imms/factory/principalAxis")
public class PrintcipalAxisController extends SimpleCRUDController<PrincipalAxis> {
    @Resource(name="principalAxisDAO")
    private PrincipalAxisDAO principalAxisDAO;

    @Override
    protected BaseDAOWithEntity<PrincipalAxis> getCrudDao() {
        return principalAxisDAO;
    }
}
