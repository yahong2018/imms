package com.zhxh.imms.material.dao;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.exception.BusinessException;
import com.zhxh.imms.code.dao.CodeSeedDAO;
import com.zhxh.imms.code.logic.CodeSeedLogic;
import com.zhxh.imms.material.entity.BomOrder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("bomOrderDAO")
public class BomOrderDAO extends BaseDAOWithEntity<BomOrder> {
    @Resource(name="codeSeedLogic")
    private CodeSeedLogic codeSeedLogic;

    @Override
    protected synchronized int doInsert(BomOrder item) {
        String bomOrderNo = codeSeedLogic.createCode("bomOrderNo");
        item.setBomOrderNo(bomOrderNo);
        return super.doInsert(item);
    }
}
