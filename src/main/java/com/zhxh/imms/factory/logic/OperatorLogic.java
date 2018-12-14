package com.zhxh.imms.factory.logic;

import com.zhxh.imms.factory.dao.OperatorDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("operatorLogic")
public class OperatorLogic {
    @Resource(name="operatorDAO")
    private OperatorDAO operatorDAO;
}
