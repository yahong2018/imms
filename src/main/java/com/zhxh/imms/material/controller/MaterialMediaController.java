package com.zhxh.imms.material.controller;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.web.ListRequest;
import com.zhxh.core.web.SimpleCRUDController;
import com.zhxh.imms.material.dao.MaterialMediaDAO;
import com.zhxh.imms.material.entity.MaterialMedia;
import com.zhxh.imms.material.vo.MaterialMediaVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/imms/material/materialMedia")
public class MaterialMediaController extends SimpleCRUDController<MaterialMedia> {
    @Resource(name="materialMediaDAO")
    private MaterialMediaDAO materialMediaDAO;

    @Override
    protected BaseDAOWithEntity<MaterialMedia> getCrudDao() {
        return this.materialMediaDAO;
    }


    @Override
    protected List<MaterialMedia> internalGetAll(ListRequest listRequest) {
        Map<String,Object> listMap = listRequest.toMap();
        Class clazz = MaterialMediaVO.class;

        return this.getCrudDao().getList(clazz,listMap);
    }
}
