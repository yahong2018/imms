package com.zhxh.imms.factory.service;

import com.zhxh.imms.factory.dao.WorkCenterDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("workCenterService")
public class WorkCenterService {
    @Resource(name="workCenterDAO")
    private WorkCenterDAO workCenterDAO;

}
