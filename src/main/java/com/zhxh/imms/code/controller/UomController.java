package com.zhxh.imms.code.controller;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.web.SimpleCRUDController;
import com.zhxh.imms.code.dao.UomDAO;
import com.zhxh.imms.code.entity.Uom;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/imms/code/uom")
public class UomController extends SimpleCRUDController<Uom> {
    @Resource(name="uomDAO")
    private UomDAO uomDAO;

    @Override
    protected BaseDAOWithEntity<Uom> getCrudDao() {
        return uomDAO;
    }
}
