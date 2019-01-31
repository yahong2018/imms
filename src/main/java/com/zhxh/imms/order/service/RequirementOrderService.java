package com.zhxh.imms.order.service;

import com.zhxh.imms.factory.dao.PlantDAO;
import com.zhxh.imms.factory.dao.WorkCenterDAO;
import com.zhxh.imms.factory.entity.Plant;
import com.zhxh.imms.factory.entity.WorkCenter;
import com.zhxh.imms.material.dao.MaterialDAO;
import com.zhxh.imms.material.entity.Material;
import com.zhxh.imms.material.service.BomService;
import com.zhxh.imms.order.dao.RequirementOrderDAO;
import com.zhxh.imms.order.entity.RequirementOrder;
import com.zhxh.imms.order.vo.RequirementOrderVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("requirementOrderService")
public class RequirementOrderService {
    @Resource(name="requirementOrderDAO")
    private RequirementOrderDAO requirementOrderDAO;

    @Resource(name="materialDAO")
    private MaterialDAO materialDAO;

    @Resource(name="workCenterDAO")
    private WorkCenterDAO workCenterDAO;

    @Resource(name="plantDAO")
    private PlantDAO plantDAO;

    @Resource(name="bomService")
    private BomService bomService;

    RequirementOrder createFromVo(RequirementOrderVO vo){
        this.vo2Entity(vo);
        this.requirementOrderDAO.insert(vo);
        return vo;
    }

    private void vo2Entity(RequirementOrderVO vo){
        if(vo.getFgMaterialId()==0){
            Material material = materialDAO.getByMaterialNo(vo.getMaterialNo());
            vo.setFgMaterialId(material.getRecordId());
        }

        if(vo.getWorkCenterId()==0){
            WorkCenter workCenter = workCenterDAO.getByWorkCenterNo(vo.getWorkCenterNo());
            vo.setWorkCenterId(workCenter.getRecordId());
        }

        if(vo.getPlantId()==0){
            Plant plant = plantDAO.getByPlantNo(vo.getPlanNo());
            vo.setPlantId(plant.getRecordId());
        }

        //
        //转换OrderSize
        //

        //
        //转换BomVO
        //
        for(int i=0;i<vo.getBomList().length;i++){
            bomService.fillFromVo(vo.getBomList()[i]);
        }
    }
}
