package com.zhxh.imms.factory.service;

import com.zhxh.imms.factory.dao.LineDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("lineService")
public class LineService {
    @Resource(name = "lineDAO")
    private LineDAO lineDAO;
}
