package com.zhxh.imms.code.controller;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.data.ParentChildConverter;
import com.zhxh.core.utils.Logger;
import com.zhxh.core.web.ListRequest;
import com.zhxh.core.web.SimpleCRUDController;
import com.zhxh.imms.code.dao.DefectCodeDAO;
import com.zhxh.imms.code.entity.DefectCode;
import com.zhxh.imms.code.vo.DefectCodeWithChildren;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/imms/code/defectCode")
public class DefectCodeController extends SimpleCRUDController<DefectCode> {
    @Resource(name="defectCodeDAO")
    private DefectCodeDAO defectCodeDAO;

    @Override
    protected BaseDAOWithEntity<DefectCode> getCrudDao() {
        return this.defectCodeDAO;
    }

    @Override
    protected List<DefectCode> internalGetAll(ListRequest listRequest) {
        List<DefectCode> source = super.internalGetAll(listRequest);
        List<DefectCode> result = new ArrayList<>();

        try {
            List<DefectCodeWithChildren> children = ParentChildConverter.getAllWithChildren(source, DefectCodeWithChildren.class,"defectCodeId","parentDefectCodeId");
            result.addAll(children);
        } catch (Exception e) {
            Logger.error(e);
        }

        return result;
    }
}
