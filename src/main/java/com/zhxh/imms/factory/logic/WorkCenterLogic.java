package com.zhxh.imms.factory.logic;

import com.zhxh.imms.factory.dao.WorkCenterDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("workCenterLogic")
public class WorkCenterLogic {
    @Resource(name="workCenterDAO")
    private WorkCenterDAO workCenterDAO;

}
