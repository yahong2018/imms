package com.zhxh.imms.order.dao;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.imms.code.service.CodeSeedService;
import com.zhxh.imms.order.entity.MaterialPickingSchedule;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("materialPickingScheduleDAO")
public class MaterialPickingScheduleDAO extends BaseDAOWithEntity<MaterialPickingSchedule> {
    @Resource(name="codeSeedService")
    private CodeSeedService codeSeedService;

    @Override
    protected int doInsert(MaterialPickingSchedule item) {
        String pickingScheduleNo = codeSeedService.createCode("materialPickingScheduleNo");
        item.setMaterialPickingScheduleNo(pickingScheduleNo);

        return super.doInsert(item);
    }
}
