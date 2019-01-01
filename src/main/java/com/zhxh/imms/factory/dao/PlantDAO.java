package com.zhxh.imms.factory.dao;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.imms.factory.entity.Plant;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("plantDAO")
public class PlantDAO extends BaseDAOWithEntity<Plant> {

    public Plant getByPlantNo(String planNo){
        Map<String, String> parameters = new HashMap<>();
        parameters.put("planNo", planNo);

        return super.getOne("plan_no=#{planNo}", parameters);
    }

}
