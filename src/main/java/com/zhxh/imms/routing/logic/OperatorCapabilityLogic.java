package com.zhxh.imms.routing.logic;

import com.zhxh.imms.routing.dao.OperatorCapabilityDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("operatorCapabilityLogic")
public class OperatorCapabilityLogic {
    @Resource(name="operatorCapability")
    private OperatorCapabilityDAO operatorCapabilityDAO;
}
