package com.zhxh.admin.entity;

import com.zhxh.core.data.EntityObject;

public class SystemRole implements EntityObject {
    private String roleId;
    private String roleName;

    public String getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
