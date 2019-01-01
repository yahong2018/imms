package com.zhxh.imms.factory.dao;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.imms.factory.entity.Machine;
import org.springframework.stereotype.Component;

@Component("machineDAO")
public class MachineDAO extends BaseDAOWithEntity<Machine> {

    public Machine getCuttingMachine(){
        String where = "work_station_id in(select record_id from work_station where work_station_type=0) limit 1";

        return this.getOne(where,null);
    }

}
