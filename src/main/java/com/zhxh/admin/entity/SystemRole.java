package com.zhxh.admin.entity;

import com.zhxh.core.data.Entity;
import com.zhxh.core.data.meta.annotation.DataTableConfiguration;
import lombok.Getter;
import lombok.Setter;

@DataTableConfiguration("system_role")
@Getter
@Setter
public class SystemRole extends Entity<Long> {
    private String roleCode;
    private String roleName;
}
