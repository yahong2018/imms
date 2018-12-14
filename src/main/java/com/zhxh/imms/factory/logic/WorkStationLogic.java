package com.zhxh.imms.factory.logic;

import com.zhxh.imms.factory.dao.WorkStationDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("workStationLogic")
public class WorkStationLogic {
    @Resource(name="workStationDAO")
    private WorkStationDAO workStationDAO;

}
