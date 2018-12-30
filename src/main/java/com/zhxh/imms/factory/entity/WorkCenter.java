package com.zhxh.imms.factory.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.DataTable;
import lombok.Getter;
import lombok.Setter;

@DataTable("work_center")
@Getter
@Setter
public class WorkCenter extends EntityObject {
    private String workCenterNo;
    private String workCenterName;
    private String description;
    private String plantId;
}
