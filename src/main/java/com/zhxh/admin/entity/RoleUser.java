package com.zhxh.admin.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.DataTable;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@DataTable("role_user")
@Getter
@Setter
public class RoleUser extends EntityObject {
    private String roleId;
    private String userId;
}
