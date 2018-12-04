package com.zhxh.imms.material.logic;

import com.zhxh.imms.material.dao.BomDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("bomLogic")
public class BomLogic {
    @Resource(name = "bomDAO")
    private BomDAO bomDAO;


}
