package com.zhxh.imms.material.controller;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.web.ListRequest;
import com.zhxh.core.web.SimpleCRUDController;
import com.zhxh.imms.material.dao.MaterialDAO;
import com.zhxh.imms.material.entity.Material;
import com.zhxh.imms.material.vo.MaterialVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/imms/material/material")
public class MaterialController extends SimpleCRUDController<Material> {
    @Resource(name = "materialDAO")
    private MaterialDAO materialDAO;

    @Override
    protected BaseDAOWithEntity<Material> getCrudDao() {
        return this.materialDAO;
    }

    @Override
    protected List internalGetByRequest(ListRequest listRequest) {
        Class clazz = MaterialVO.class;
        return this.materialDAO.getPageList(clazz,listRequest.toMap(),null);
    }

    @Override
    protected int internalGetRequestListCount(ListRequest listRequest) {
        Class clazz = MaterialVO.class;
        return this.materialDAO.getPageListCount(clazz,listRequest.toMap(),null);
    }
}
