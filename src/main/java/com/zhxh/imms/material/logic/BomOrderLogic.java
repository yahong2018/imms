package com.zhxh.imms.material.logic;

import com.zhxh.imms.material.dao.BomOrderDAO;
import com.zhxh.imms.material.entity.BomOrder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("bomOrderLogic")
public class BomOrderLogic {
    @Resource(name="bomOrderDAO")
    private BomOrderDAO bomOrderDAO;

    public BomOrder createBomOrder(String bomOrderTypeNo) {
        BomOrder bomOrder = new BomOrder();
        bomOrder.setBomOrderTypeNo(bomOrderTypeNo);
        this.bomOrderDAO.insert(bomOrder);

        return bomOrder;
    }

}
