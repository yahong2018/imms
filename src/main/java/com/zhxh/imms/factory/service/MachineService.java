package com.zhxh.imms.factory.service;

import com.zhxh.imms.factory.dao.MachineDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("machineService")
public class MachineService {
    @Resource(name="machineDAO")
    private MachineDAO machineDAO;

}
