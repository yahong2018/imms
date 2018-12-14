package com.zhxh.imms.factory.logic;

import com.zhxh.imms.factory.dao.MachineDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("machineLogic")
public class MachineLogic {
    @Resource(name="machineDAO")
    private MachineDAO machineDAO;

}
