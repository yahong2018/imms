package com.zhxh.imms.factory.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.DataTable;
import lombok.Getter;
import lombok.Setter;

@DataTable("principal_axis")
@Getter
@Setter
public class PrincipalAxis extends EntityObject {
    private String principalAxisNo;
    private int sequenceNumber;
    private int rotatingDirection;
    private double length;
    private double width;
    private double speed;
    private String workCenterId;
}
