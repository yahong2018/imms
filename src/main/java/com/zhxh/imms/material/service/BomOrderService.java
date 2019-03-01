package com.zhxh.imms.material.service;

import com.zhxh.imms.material.dao.BomOrderDAO;
import com.zhxh.imms.material.entity.BomOrder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("bomOrderService")
public class BomOrderService {
    @Resource(name="bomOrderDAO")
    private BomOrderDAO bomOrderDAO;

    public BomOrder createBomOrder(int bomOrderTypeNo) {
        BomOrder bomOrder = new BomOrder();
        bomOrder.setBomOrderTypeNo(bomOrderTypeNo);
        this.bomOrderDAO.insert(bomOrder);

        return bomOrder;
    }
}
