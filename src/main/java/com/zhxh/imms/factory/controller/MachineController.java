package com.zhxh.imms.factory.controller;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.web.SimpleCRUDController;
import com.zhxh.imms.factory.dao.MachineDAO;
import com.zhxh.imms.factory.entity.Machine;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/imms/factory/machine")
public class MachineController extends SimpleCRUDController<Machine> {
    @Resource(name="machineDAO")
    private MachineDAO machineDAO;

    @Override
    protected BaseDAOWithEntity<Machine> getCrudDao() {
        return machineDAO;
    }
}
