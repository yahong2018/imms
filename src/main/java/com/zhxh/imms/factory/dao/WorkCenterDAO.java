package com.zhxh.imms.factory.dao;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.imms.factory.entity.WorkCenter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("workCenterDAO")
public class WorkCenterDAO extends BaseDAOWithEntity<WorkCenter> {

    public WorkCenter getByWorkCenterNo(String workCenterNo){
        Map<String, String> parameters = new HashMap<>();
        parameters.put("workCenterNo", workCenterNo);

        return super.getOne("work_center_no=#{workCenterNo}", parameters);
    }
}
