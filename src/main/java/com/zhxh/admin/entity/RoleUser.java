package com.zhxh.admin.entity;

import javax.validation.constraints.NotEmpty;

public class RoleUser {
    private int roleUserId;
    
    @NotEmpty
    private String roleId;
    
    @NotEmpty
    private String userId;

    public String getRoleId() {
        return roleId;
    }

    public String getUserId() {
        return userId;
    }

    public int getRoleUserId() {
        return roleUserId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setRoleUserId(int roleUserId) {
        this.roleUserId = roleUserId;
    }
}
