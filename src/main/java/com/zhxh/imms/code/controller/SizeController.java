package com.zhxh.imms.code.controller;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.web.SimpleCRUDController;
import com.zhxh.imms.code.dao.SizeDAO;
import com.zhxh.imms.code.entity.Size;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/imms/code/size")
public class SizeController extends SimpleCRUDController<Size> {
    @Resource(name="sizeDAO")
    private SizeDAO sizeDAO;

    @Override
    protected BaseDAOWithEntity<Size> getCrudDao() {
        return this.sizeDAO;
    }
}
