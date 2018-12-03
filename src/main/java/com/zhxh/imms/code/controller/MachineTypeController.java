package com.zhxh.imms.code.controller;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.data.ParentChildConverter;
import com.zhxh.core.utils.Logger;
import com.zhxh.core.web.ListRequest;
import com.zhxh.core.web.SimpleCRUDController;
import com.zhxh.imms.code.dao.MachineTypeDAO;
import com.zhxh.imms.code.entity.MachineType;
import com.zhxh.imms.code.vo.MachineTypeWithChildren;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/imms/code/machineType")
public class MachineTypeController extends SimpleCRUDController<MachineType> {
    @Resource(name="machineTypeDAO")
    private MachineTypeDAO machineTypeDAO;

    @Override
    protected BaseDAOWithEntity<MachineType> getCrudDao() {
        return this.machineTypeDAO;
    }

    @Override
    protected List<MachineType> internalGetAll(ListRequest listRequest) {
        List<MachineType> source = super.internalGetAll(listRequest);
        List<MachineType> result = new ArrayList<>();

        try {
            List<MachineTypeWithChildren> children = ParentChildConverter.getAllWithChildren(source, MachineTypeWithChildren.class,"machineTypeId","parentMachineTypeId");
            result.addAll(children);
        } catch (Exception e) {
            Logger.error(e);
        }

        return result;
    }
}
