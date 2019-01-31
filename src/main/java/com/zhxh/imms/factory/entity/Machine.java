package com.zhxh.imms.factory.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.DataTableConfiguration;
import lombok.Getter;
import lombok.Setter;

@DataTableConfiguration("machine")
@Getter
@Setter
public class Machine extends EntityObject {
    private String machineNo;
    private String machineName;
    private String machineTypeId;
    private String machineStatus;
    private String description;
    private String workStationId;
}
