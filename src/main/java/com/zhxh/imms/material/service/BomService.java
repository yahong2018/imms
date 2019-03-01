package com.zhxh.imms.material.service;

import com.zhxh.core.exception.ErrorCode;
import com.zhxh.imms.code.dao.UomDAO;
import com.zhxh.imms.code.entity.Uom;
import com.zhxh.imms.material.dao.BomDAO;
import com.zhxh.imms.material.dao.MaterialDAO;
import com.zhxh.imms.material.entity.Material;
import com.zhxh.imms.material.vo.BomVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("bomService")
public class BomService {
    @Resource(name = "bomDAO")
    private BomDAO bomDAO;

    @Resource(name="materialDAO")
    private MaterialDAO materialDAO;

    @Resource(name="uomDAO")
    private UomDAO uomDAO;


    public void fillFromVo(BomVO vo) {
        if (vo.getComponentMaterialId() <= 0) {
            Material material = materialDAO.getOneByField("material_no","materialNo",vo.getComponentMaterialNo());
            if(material==null){
                com.zhxh.core.exception.ExceptionHelper.throwException(ErrorCode.ERROR_DATA_NOT_EXISTS, "BOM的组件编号错误！");
            }
            vo.setComponentMaterialId(material.getRecordId());
            vo.setComponentMaterialName(material.getMaterialName());
            vo.setComponentUomId(material.getMaterialUomId());
        }

        if (vo.getComponentAbstractMaterialId() <= 0) {
            Material material = materialDAO.getOneByField("material_no","materialNo",vo.getComponentAbstractMaterialNo());
            if(material==null){
                com.zhxh.core.exception.ExceptionHelper.throwException(ErrorCode.ERROR_DATA_NOT_EXISTS, "BOM的组件编号错误！");
            }
            vo.setComponentAbstractMaterialId(material.getRecordId());
            vo.setComponentAbstractMaterialName(material.getMaterialName());
        }

        if(vo.getComponentUomId()<=0){
            Uom uom = uomDAO.getOneByField("uom_id","uomId",vo.getComponentUomNo());
            if(uom==null){
                com.zhxh.core.exception.ExceptionHelper.throwException(ErrorCode.ERROR_DATA_NOT_EXISTS, "BOM的用量单位错误！");
            }
            vo.setComponentUomId(uom.getRecordId());
        }

        if (vo.getComponentMaterialMatchRuleId() <= 0) {
            //物料拣配规则暂时不启用
        }
    }
}
