package com.zhxh.imms.routing.dao;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.imms.code.logic.CodeSeedLogic;
import com.zhxh.imms.routing.entity.OperationRoutingOrder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Component("operationRoutingOrderDAO")
public class OperationRoutingOrderDAO extends BaseDAOWithEntity<OperationRoutingOrder> {
    @Resource(name="codeSeedLogic")
    private CodeSeedLogic codeSeedLogic;

    public OperationRoutingOrder getByRefId(String refId){
        Map<String, String> parameters = new HashMap<>();
        parameters.put("refId", refId);

        return super.getOne("ref_id=#{refId}", parameters);
    }

    @Override
    protected int doInsert(OperationRoutingOrder item) {
        String operationRoutingOrderNo = codeSeedLogic.createCode("operationRoutingOrderNo");
        item.setOperationRoutingOrderNo(operationRoutingOrderNo);

        return super.doInsert(item);
    }
}
