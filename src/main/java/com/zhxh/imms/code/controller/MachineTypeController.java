package com.zhxh.imms.code.controller;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.web.SimpleCRUDController;
import com.zhxh.imms.code.dao.MachineTypeDAO;
import com.zhxh.imms.code.entity.MachineType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/imms/code/machineType")
public class MachineTypeController extends SimpleCRUDController<MachineType> {
    @Resource(name="machineTypeDAO")
    private MachineTypeDAO machineTypeDAO;

    @Override
    protected BaseDAOWithEntity<MachineType> getCrudDao() {
        return this.machineTypeDAO;
    }
}
