package com.zhxh.imms.routing.logic;

import com.zhxh.imms.routing.dao.OperationMediaDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("operationMediaLogic")
public class OperationMediaLogic {
    @Resource(name="operationMediaDAO")
    private OperationMediaDAO operationMediaDAO;

}
