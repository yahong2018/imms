package com.zhxh.imms.code.controller;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.data.ParentChildConverter;
import com.zhxh.core.utils.Logger;
import com.zhxh.core.web.SimpleCRUDController;
import com.zhxh.imms.code.dao.MaterialTypeDAO;
import com.zhxh.imms.code.entity.MaterialType;
import com.zhxh.imms.code.entity.Size;
import com.zhxh.imms.code.vo.MaterialTypeWithChildren;
import com.zhxh.imms.code.vo.SizeWithChildren;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/imms/code/materialType")
public class MaterialTypeController extends SimpleCRUDController<MaterialType> {
    @Resource(name="materialTypeDAO")
    private MaterialTypeDAO materialTypeDAO;

    @Override
    protected BaseDAOWithEntity<MaterialType> getCrudDao() {
        return this.materialTypeDAO;
    }

    @Override
    protected List<MaterialType> internalGetAll() {
        List<MaterialType> source = super.internalGetAll();
        List<MaterialType> result = new ArrayList<>();

        try {
            List<MaterialTypeWithChildren> children = ParentChildConverter.getAllWithChildren(source, MaterialTypeWithChildren.class,"rowId","parentMaterialTypeId");
            result.addAll(children);
        } catch (Exception e) {
            Logger.error(e);
        }

        return result;
    }
}
