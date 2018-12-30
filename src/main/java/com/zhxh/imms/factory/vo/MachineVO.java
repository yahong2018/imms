package com.zhxh.imms.factory.vo;

import com.zhxh.imms.factory.entity.Machine;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MachineVO extends Machine {
    private String workStationNo;
    private String workStationName;
    private String machineTypeNo;
    private String machineTypeName;
}
