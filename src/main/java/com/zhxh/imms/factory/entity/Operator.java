package com.zhxh.imms.factory.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.DataTableConfiguration;
import lombok.Getter;
import lombok.Setter;

@DataTableConfiguration("operator")
@Getter
@Setter
public class Operator extends EntityObject {
    private String userId;
    private String plantId;
    private String supervisorId;
}
