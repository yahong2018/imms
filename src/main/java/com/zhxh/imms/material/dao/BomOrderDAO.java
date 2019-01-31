package com.zhxh.imms.material.dao;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.imms.code.service.CodeSeedService;
import com.zhxh.imms.material.entity.BomOrder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("bomOrderDAO")
public class BomOrderDAO extends BaseDAOWithEntity<BomOrder> {
    @Resource(name="codeSeedService")
    private CodeSeedService codeSeedService;

    @Override
    protected synchronized int doInsert(BomOrder item) {
        String bomOrderNo = codeSeedService.createCode("bomOrderNo");
        item.setBomOrderNo(bomOrderNo);
        return super.doInsert(item);
    }
}
