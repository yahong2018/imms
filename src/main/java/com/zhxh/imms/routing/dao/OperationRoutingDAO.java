package com.zhxh.imms.routing.dao;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.imms.routing.entity.OperationRouting;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("operationRoutingDAO")
public class OperationRoutingDAO extends BaseDAOWithEntity<OperationRouting> {
    public List<OperationRouting> getByOperationRoutingOrderId(Long operationRoutingOrderId) {
        Map<String, String> listMap = new HashMap<>();
        listMap.put("where", "operation_routing_order_id=#{operationRoutingOrderId}");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("operationRoutingOrderId", operationRoutingOrderId);

        return this.getList(listMap, parameters);
    }

    public OperationRouting getCuttingOperationRouting(){
        String where = "machine_type_id in (\n"
             +"   select machine_type_id from machine \n"
             +"       where work_station_id in(\n"
             +"          select record_id from work_station \n"
             +"              where work_station_type=0\n"
             +"       )\n"
             +")\n"
             +" limit 1 ";

        return this.getOne(where,null);
    }
}
