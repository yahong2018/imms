package com.zhxh.imms.factory.service;

import com.zhxh.imms.factory.dao.WorkStationDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("workStationService")
public class WorkStationService {
    @Resource(name="workStationDAO")
    private WorkStationDAO workStationDAO;

}
