package com.zhxh.imms.code.controller;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.data.ParentChildConverter;
import com.zhxh.core.utils.Logger;
import com.zhxh.core.web.ListRequest;
import com.zhxh.core.web.SimpleCRUDController;
import com.zhxh.imms.code.dao.SizeDAO;
import com.zhxh.imms.code.entity.MachineType;
import com.zhxh.imms.code.entity.Size;
import com.zhxh.imms.code.vo.MachineTypeWithChildren;
import com.zhxh.imms.code.vo.SizeWithChildren;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/imms/code/size")
public class SizeController extends SimpleCRUDController<Size> {
    @Resource(name="sizeDAO")
    private SizeDAO sizeDAO;

    @Override
    protected BaseDAOWithEntity<Size> getCrudDao() {
        return this.sizeDAO;
    }


    @Override
    protected List<Size> internalGetAll(ListRequest listRequest) {
        List<Size> source = super.internalGetAll(listRequest);
        List<Size> result = new ArrayList<>();

        try {
            List<SizeWithChildren> children = ParentChildConverter.getAllWithChildren(source, SizeWithChildren.class,"sizeId","parentSizeId");
            result.addAll(children);
        } catch (Exception e) {
            Logger.error(e);
        }

        return result;
    }
}
