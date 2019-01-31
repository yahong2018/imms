package com.zhxh.imms.routing.service;

import com.zhxh.imms.routing.dao.OperationDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("operationService")
public class OperationService {
    @Resource(name="operationDAO")
    private OperationDAO operationDAO;

}
