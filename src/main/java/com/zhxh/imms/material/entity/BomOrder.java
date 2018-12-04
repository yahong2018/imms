package com.zhxh.imms.material.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.AutoGeneration;
import com.zhxh.core.data.meta.annotation.CheckUnique;

import java.util.HashMap;
import java.util.Map;

public class BomOrder implements EntityObject {
    public final static String PART_BOM = "P";
    public final static String STANDARD_BOM = "S";
    public final static String ORDER_BOM = "O";
    public final static String DESIGN_BOM = "D";
    public final static String MANUFACTURE_BOM = "M";
    public final static String WORK_BOM = "W";

    @AutoGeneration
    private String bomOrderId;

    @CheckUnique
    private String bomOrderNo;
    private String bomOrderTypeNo;

    public String getBomOrderId() {
        return bomOrderId;
    }

    public void setBomOrderId(String bomOrderId) {
        this.bomOrderId = bomOrderId;
    }

    public String getBomOrderNo() {
        return bomOrderNo;
    }

    public void setBomOrderNo(String bomOrderNo) {
        this.bomOrderNo = bomOrderNo;
    }

    public String getBomOrderTypeNo() {
        return bomOrderTypeNo;
    }

    public void setBomOrderTypeNo(String bomOrderTypeNo) {
        this.bomOrderTypeNo = bomOrderTypeNo;
    }

    public String getBomOrderTypeName() {
        if(bomTypeNames.containsKey(this.getBomOrderTypeNo())){
            return bomTypeNames.get(this.getBomOrderTypeNo());
        }
        return this.getBomOrderTypeNo();
    }

    private final static Map<String, String> bomTypeNames = new HashMap<String, String>() {
        {
            put(PART_BOM, "部件BOM");
            put(STANDARD_BOM, "基准BOM");
            put(ORDER_BOM, "订单BOM");
            put(DESIGN_BOM, "设计BOM");
            put(MANUFACTURE_BOM, "生产BOM");
            put(WORK_BOM, "作业BOM");
        }
    };
}
