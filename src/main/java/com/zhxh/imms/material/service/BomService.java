package com.zhxh.imms.material.service;

import com.zhxh.imms.material.dao.BomDAO;
import com.zhxh.imms.material.vo.BomVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("bomService")
public class BomService {
    @Resource(name = "bomDAO")
    private BomDAO bomDAO;


    public void fillFromVo(BomVO vo){
        if(vo.getComponentMaterialId()==0){

        }
        if(StringUtils.isEmpty(vo.getComponentUomId())){

        }
        if(vo.getComponentAbstractMaterialId()==0){

        }

        if(vo.getComponentMaterialMatchRuleId()==0){

        }
    }
}
