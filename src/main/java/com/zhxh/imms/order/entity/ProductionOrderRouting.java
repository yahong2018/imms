package com.zhxh.imms.order.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.DataTable;
import lombok.Getter;
import lombok.Setter;

@DataTable("production_order_routing")
@Getter
@Setter
public class ProductionOrderRouting extends EntityObject {
    private String productionOrderId;
    private String operationId;
    private String qaProcedure;
    private String machineTypeId;
    private float  standardTime;
    private float  standardPrice;
    private String sectionType;
    private String preOperationId;
    private String sopFilePath;
}
