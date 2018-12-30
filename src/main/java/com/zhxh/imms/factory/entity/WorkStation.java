package com.zhxh.imms.factory.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.DataTable;
import lombok.Getter;
import lombok.Setter;

@DataTable("work_station")
@Getter
@Setter
public class WorkStation extends EntityObject {
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
