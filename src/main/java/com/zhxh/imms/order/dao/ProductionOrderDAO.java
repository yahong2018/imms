package com.zhxh.imms.order.dao;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.imms.code.service.CodeSeedService;
import com.zhxh.imms.order.entity.ProductionOrder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("productionOrderDAO")
public class ProductionOrderDAO  extends BaseDAOWithEntity<ProductionOrder> {
    @Resource(name="codeSeedService")
    private CodeSeedService codeSeedService;

    @Override
    protected int doInsert(ProductionOrder item) {
        String productionOrderNo = codeSeedService.createCode("productionOrderNo");
        item.setProductionOrderNo(productionOrderNo);

        return super.doInsert(item);
    }
}
