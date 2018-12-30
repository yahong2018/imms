package com.zhxh.imms.factory.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.DataTable;
import lombok.Getter;
import lombok.Setter;

@DataTable("line")
@Getter
@Setter
public class Line extends EntityObject {
    private String workCenterId;
    private int    sequenceNumber;
    private String startMainLineId;
    private String endMainLineId;
    private double length;
    private double width;
    private int rotatingDirection;
    private double speed;
    private double preLinesSpacing;
    private double leftDistance;
    private String productionLineCode;
}
