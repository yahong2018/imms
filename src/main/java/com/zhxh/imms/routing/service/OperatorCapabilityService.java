package com.zhxh.imms.routing.service;

import com.zhxh.imms.routing.dao.OperatorCapabilityDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("operatorCapabilityService")
public class OperatorCapabilityService {
    @Resource(name="operatorCapability")
    private OperatorCapabilityDAO operatorCapabilityDAO;
}
