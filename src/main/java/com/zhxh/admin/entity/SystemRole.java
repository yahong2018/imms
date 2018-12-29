package com.zhxh.admin.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.DataTable;
import lombok.Getter;
import lombok.Setter;

@DataTable("system_role")
@Getter
@Setter
public class SystemRole extends EntityObject {
    private String roleCode;
    private String roleName;
}
