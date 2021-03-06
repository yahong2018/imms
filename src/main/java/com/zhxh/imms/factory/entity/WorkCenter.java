package com.zhxh.imms.factory.entity;

import com.zhxh.core.data.Entity;
import com.zhxh.core.data.meta.annotation.DataTableConfiguration;
import lombok.Getter;
import lombok.Setter;

@DataTableConfiguration("work_center")
@Getter
@Setter
public class WorkCenter extends Entity<Long> {
    private String workCenterNo;
    private String workCenterName;
    private String description;
    private Long plantId;
}
