package com.zhxh.imms.order.entity;

import com.zhxh.core.data.TraceableEntity;
import com.zhxh.core.data.meta.annotation.DataTableConfiguration;
import lombok.Getter;
import lombok.Setter;

@DataTableConfiguration("material_picking_Schedule_bom")
@Getter
@Setter
public class MaterialPickingScheduleBom extends TraceableEntity<Long> {
    private Long component_material_id;
    private Double qty;
    private Long component_material_uom_id;
    private Double picked_qty;
    private Long material_picking_order_id;
}
