package com.zhxh.imms.factory.logic;

import com.zhxh.imms.factory.dao.PlantDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("plantLogic")
public class PlantLogic {
    @Resource(name="plantDAO")
    private PlantDAO plantDAO;
}
