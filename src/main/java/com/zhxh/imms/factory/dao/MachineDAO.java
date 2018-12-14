package com.zhxh.imms.factory.dao;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.imms.factory.entity.Machine;
import org.springframework.stereotype.Component;

@Component("machineDAO")
public class MachineDAO extends BaseDAOWithEntity<Machine> {
}
