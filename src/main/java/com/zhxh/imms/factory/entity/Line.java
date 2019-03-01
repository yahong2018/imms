package com.zhxh.imms.factory.entity;

import com.zhxh.core.data.Entity;
import com.zhxh.core.data.meta.annotation.DataTableConfiguration;
import lombok.Getter;
import lombok.Setter;

@DataTableConfiguration("line")
@Getter
@Setter
public class Line extends Entity {
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
