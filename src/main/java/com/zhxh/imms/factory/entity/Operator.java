package com.zhxh.imms.factory.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.DataTable;
import lombok.Getter;
import lombok.Setter;

@DataTable("operator")
@Getter
@Setter
public class Operator extends EntityObject {
    private String userId;
    private String plantId;
    private String supervisorId;
}
