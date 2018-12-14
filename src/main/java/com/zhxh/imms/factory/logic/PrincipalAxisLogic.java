package com.zhxh.imms.factory.logic;

import com.zhxh.imms.factory.dao.PrincipalAxisDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("principalAxisLogic")
public class PrincipalAxisLogic {
    @Resource(name="principalAxisDAO")
    private PrincipalAxisDAO principalAxisDAO;
}
