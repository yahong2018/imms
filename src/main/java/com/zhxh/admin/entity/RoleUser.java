package com.zhxh.admin.entity;

import com.zhxh.core.data.Entity;
import com.zhxh.core.data.meta.annotation.DataTableConfiguration;
import lombok.Getter;
import lombok.Setter;

@DataTableConfiguration("role_user")
@Getter
@Setter
public class RoleUser extends Entity<Long> {
    private Long roleId;
    private Long userId;
}
