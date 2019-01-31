package com.zhxh.imms.factory.service;

import com.zhxh.imms.factory.dao.PrincipalAxisDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("principalAxisService")
public class PrincipalAxisService {
    @Resource(name="principalAxisDAO")
    private PrincipalAxisDAO principalAxisDAO;
}
