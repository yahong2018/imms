package com.zhxh.imms.factory.vo;

import com.zhxh.imms.factory.entity.WorkStation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkStationVO extends WorkStation {
    private String plantName;
    private String plantNo;
    private String workCenterNo;
    private String workCenterName;
}
