package com.zhxh.imms.routing.logic;

import com.zhxh.imms.routing.dao.OperationDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("operationLogic")
public class OperationLogic {
    @Resource(name="operationDAO")
    private OperationDAO operationDAO;

}
