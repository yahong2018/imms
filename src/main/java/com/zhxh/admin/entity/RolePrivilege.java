package com.zhxh.admin.entity;

import com.zhxh.core.data.EntityObject;

public class RolePrivilege implements EntityObject {
    private int rolePrivilegeId;
    private int programPrivilegeId;
    private String roleId;
    private String programId;
    private String privilegeId;

    public RolePrivilege(){}
    public RolePrivilege(String roleId, ProgramPrivilege programPrivilege){
        this.setRoleId(roleId);
        this.setPrivilegeId(programPrivilege.getPrivilegeId());
        this.setProgramId(programPrivilege.getProgramId());
        this.setProgramPrivilegeId(programPrivilege.getProgramPrivilegeId());
    }

    public int getProgramPrivilegeId() {
        return programPrivilegeId;
    }

    public void setProgramPrivilegeId(int programPrivilegeId) {
        this.programPrivilegeId = programPrivilegeId;
    }

    public String getRoleId() {
        return roleId;
    }

    public int getRolePrivilegeId() {
        return rolePrivilegeId;
    }

    public String getPrivilegeId() {
        return privilegeId;
    }

    public String getProgramId() {
        return programId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public void setPrivilegeId(String privilegeId) {
        this.privilegeId = privilegeId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public void setRolePrivilegeId(int rolePrivilegeId) {
        this.rolePrivilegeId = rolePrivilegeId;
    }
}
