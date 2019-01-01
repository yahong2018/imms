package com.zhxh.imms.factory.dao;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.data.DataCode.BCode;
import com.zhxh.imms.factory.entity.WorkStation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("workStationDAO")
public class WorkStationDAO extends BaseDAOWithEntity<WorkStation> {
    public WorkStation getCuttingWorkStation(){
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("workStationType", BCode.WORK_STATION_TYPE_CUT);

        return super.getOne("work_station_type=#{workStationType}", parameters);
    }

}
