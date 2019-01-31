package com.zhxh.imms.factory.service;

import com.zhxh.imms.factory.dao.OperatorDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("operatorService")
public class OperatorService {
    @Resource(name="operatorDAO")
    private OperatorDAO operatorDAO;
}
