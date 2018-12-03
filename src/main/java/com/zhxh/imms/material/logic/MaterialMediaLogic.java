package com.zhxh.imms.material.logic;

import com.zhxh.imms.material.dao.MaterialMediaDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("materialMediaLogic")
public class MaterialMediaLogic {
    @Resource(name="materialMediaDAO")
    private MaterialMediaDAO materialMediaDAO;
}
