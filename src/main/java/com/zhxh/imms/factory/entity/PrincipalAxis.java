package com.zhxh.imms.factory.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.DataTableConfiguration;
import lombok.Getter;
import lombok.Setter;

@DataTableConfiguration("principal_axis")
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
