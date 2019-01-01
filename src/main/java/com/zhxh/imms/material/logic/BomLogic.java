package com.zhxh.imms.material.logic;

import com.zhxh.imms.material.dao.BomDAO;
import com.zhxh.imms.material.vo.BomVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("bomLogic")
public class BomLogic {
    @Resource(name = "bomDAO")
    private BomDAO bomDAO;


    public void fillFromVo(BomVO vo){
        if(StringUtils.isEmpty(vo.getComponentMaterialId())){

        }
        if(StringUtils.isEmpty(vo.getComponentUomId())){

        }
        if(StringUtils.isEmpty(vo.getComponentAbstractMaterialId())){

        }

        if(StringUtils.isEmpty(vo.getComponentMaterialMatchRuleId())){

        }
    }
}
