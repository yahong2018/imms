package com.zhxh.imms.factory.entity;

import com.zhxh.core.data.Entity;
import com.zhxh.core.data.meta.annotation.DataTableConfiguration;
import lombok.Getter;
import lombok.Setter;

@DataTableConfiguration("work_station")
@Getter
@Setter
public class WorkStation extends Entity {
    private String workStationNo;
    private String plantId;
    private String description;
    private int workStationType;
    private boolean virtual;
    private String workStationStatus;
    private String direction;
    private String ipAddress;
    private int maxWipQty;
    private int currentWipQty;
    private String workCenterId;
    private String fileAddress;
}
