package com.zhxh.imms.material.controller;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.data.ParentChildConverter;
import com.zhxh.core.utils.Logger;
import com.zhxh.core.web.ListRequest;
import com.zhxh.core.web.SimpleCRUDController;
import com.zhxh.imms.material.dao.BomDAO;
import com.zhxh.imms.material.entity.Bom;
import com.zhxh.imms.material.vo.BomVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/imms/material/bom")
public class BomController extends SimpleCRUDController<Bom> {
    @Resource(name="bomDAO")
    private BomDAO bomDAO;

    @Override
    protected BaseDAOWithEntity<Bom> getCrudDao() {
        return this.bomDAO;
    }

    @Override
    protected List<Bom> internalGetAll(ListRequest listRequest) {
        List<Bom> source = super.internalGetAll(listRequest);
        List<Bom> result = new ArrayList<>();
        try {
            List<BomVO> children = ParentChildConverter.getAllWithChildren(source, BomVO.class,"bomId","parentBomId");
            result.addAll(children);
        } catch (Exception e) {
            Logger.error(e);
        }

        return result;
    }
}
