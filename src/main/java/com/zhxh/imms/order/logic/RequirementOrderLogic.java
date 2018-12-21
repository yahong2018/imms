package com.zhxh.imms.order.logic;

import com.zhxh.imms.order.dao.RequirementOrderDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("requirementOrderLogic")
public class RequirementOrderLogic {
    @Resource(name="requirementOrderDAO")
    private RequirementOrderDAO requirementOrderDAO;


}
