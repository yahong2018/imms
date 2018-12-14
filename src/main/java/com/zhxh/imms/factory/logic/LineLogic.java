package com.zhxh.imms.factory.logic;

import com.zhxh.imms.factory.dao.LineDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("lineLogic")
public class LineLogic {
    @Resource(name = "lineDAO")
    private LineDAO lineDAO;
}
