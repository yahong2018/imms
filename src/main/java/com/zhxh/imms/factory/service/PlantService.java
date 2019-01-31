package com.zhxh.imms.factory.service;

import com.zhxh.imms.factory.dao.PlantDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("plantService")
public class PlantService {
    @Resource(name="plantDAO")
    private PlantDAO plantDAO;
}
