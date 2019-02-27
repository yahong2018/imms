package com.zhxh.imms.order.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.DataTableConfiguration;
import com.zhxh.imms.material.vo.BomVO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@DataTableConfiguration("requirement_order")
@Getter
@Setter
public class RequirementOrder extends EntityObject<Long> {
    private String requirementOrderNo;
    private int requirementOrderType;
    private int requirementOrderStatus;
    private int priority;
    private Long plantId;
    private Long workCenterId;
    private Long fgMaterialId;
    private int plannedQty;
    private LocalDateTime requiredDeliveryDate;
    private String saleOrderNo;
    private int repeatType;

    private OrderSize[] orderSizeList;
    private BomVO[] bomList;
    private OrderMeasure[] measureDataList;
}
