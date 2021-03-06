package com.zhxh.imms.code.entity;

import com.zhxh.core.data.Entity;
import com.zhxh.core.data.meta.annotation.*;
import lombok.Getter;
import lombok.Setter;

@DataTableConfiguration("machine_type")
@TreeTable
@Getter
@Setter
public class MachineType extends Entity<Long> {
    @CheckUnique
    private String machineTypeNo;
    private String machineTypeName;
    private String description;
    @TreeTableParentKey
    private String parentMachineTypeId;
    private String machineTypeNoPath;
    private String machineTypeNamePath;
}
