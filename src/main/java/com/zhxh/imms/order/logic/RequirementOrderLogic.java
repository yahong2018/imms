package com.zhxh.imms.order.logic;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.utils.BeanUtils;
import com.zhxh.imms.order.dao.RequirementOrderDAO;
import com.zhxh.imms.order.entity.RequirementOrder;
import com.zhxh.imms.order.vo.RequirementOrderVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("requirementOrderLogic")
public class RequirementOrderLogic {
    @Resource(name="requirementOrderDAO")
    private RequirementOrderDAO requirementOrderDAO;

    RequirementOrder createFromVo(RequirementOrderVO vo){
        RequirementOrder requirementOrder = this.vo2Entity(vo);
        this.requirementOrderDAO.insert(requirementOrder);
        return requirementOrder;
    }

    private RequirementOrder vo2Entity(RequirementOrderVO vo){
        RequirementOrder result = new RequirementOrder();
        BeanUtils.copy(vo,result);
        if(StringUtils.isEmpty(vo.getRequirementOrderFgMaterialId())){
            //
            //设置MaterialId
            //
        }

        if(StringUtils.isEmpty(vo.getRequirementOrderWorkCenterId())){
            //
            //设置WorkCenter
            //
        }

        if(StringUtils.isEmpty(vo.getRequirementOrderPlantId())){
            //
            //设置工厂
            //
        }

        //
        //转换OrderSize
        //

        //
        //转换Bom
        //

        return result;
    }
}
