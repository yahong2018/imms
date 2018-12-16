package com.zhxh.imms.mes.ro.logic;

import com.zhxh.imms.mes.ro.dao.RequirementOrderDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("requirementOrderLogic")
public class RequirementOrderLogic {
    @Resource(name="requirementOrderDAO")
    private RequirementOrderDAO requirementOrderDAO;

}
