package com.zhxh.imms.factory.entity;

import com.zhxh.core.data.Entity;
import com.zhxh.core.data.meta.annotation.DataTableConfiguration;
import lombok.Getter;
import lombok.Setter;

@DataTableConfiguration("operator")
@Getter
@Setter
public class Operator extends Entity {
    private String userId;
    private String plantId;
    private String supervisorId;
}
