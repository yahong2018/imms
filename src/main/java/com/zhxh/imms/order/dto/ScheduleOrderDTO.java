package com.zhxh.imms.order.dto;

import com.zhxh.imms.material.vo.BomVO;
import com.zhxh.imms.order.entity.OrderMeasure;
import com.zhxh.imms.order.entity.OrderSize;
import com.zhxh.imms.order.entity.ScheduleOrder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleOrderDTO extends ScheduleOrder {
    private OrderSize[] orderSizes;  //订单尺码
    private BomVO[] boms;  //定制BOM
    private OrderMeasure[] measures;//量体信息
}
