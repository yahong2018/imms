package com.zhxh.imms.routing.dao;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.imms.code.service.CodeSeedService;
import com.zhxh.imms.routing.entity.OperationRoutingOrder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Component("operationRoutingOrderDAO")
public class OperationRoutingOrderDAO extends BaseDAOWithEntity<OperationRoutingOrder> {
    @Resource(name="codeSeedService")
    private CodeSeedService codeSeedService;

    public OperationRoutingOrder getByRefId(Long refId){
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("refId", refId);

        return super.getOne("ref_id=#{refId}", parameters);
    }

    @Override
    protected int doInsert(OperationRoutingOrder item) {
        String operationRoutingOrderNo = codeSeedService.createCode("operationRoutingOrderNo");
        item.setOperationRoutingOrderNo(operationRoutingOrderNo);

        return super.doInsert(item);
    }
}
