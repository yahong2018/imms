package com.zhxh.imms.order.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.DataTable;
import com.zhxh.imms.material.vo.BomVO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@DataTable("requirement_order")
@Getter
@Setter
public class RequirementOrder extends EntityObject {
    private String requirementOrderNo;
    private int requirementOrderType;
    private int requirementOrderStatus;
    private int    priority;
    private String plantId;
    private String workCenterId;
    private String fgMaterialId;
    private int    plannedQty;
    private LocalDateTime requiredDeliveryDate;
    private String saleOrderNo;
    private int repeatType;

    private ProductionOrderSize[] orderSizeList;
    private BomVO[] bomList;
    private ProductionOrderMeasureData[] measureDataList;
}
