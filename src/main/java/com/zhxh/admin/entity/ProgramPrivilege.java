package com.zhxh.admin.entity;

import com.zhxh.core.data.EntityObject;

public class ProgramPrivilege implements EntityObject {
    public final static String PROGRAM_RUN = "PROGRAM_RUN";
    public final static String DATA_INSERT = "INSERT";
    public final static String DATA_UPDATE = "UPDATE";
    public final static String DATA_DELETE = "DELETE";

    private int programPrivilegeId;
    private String programId;
    private String privilegeId;
    private String privilegeName;

    public String getProgramId() {
        return programId;
    }

    public boolean isInsertPrivilege() {
        return DATA_INSERT.equals(this.privilegeId);
    }

    public boolean isUpdatePrivilege() {
        return DATA_UPDATE.equals(this.privilegeId);
    }

    public boolean isDeletePrivilege() {
        return DATA_DELETE.equals(this.privilegeId);
    }

    public boolean isRunPrivilege() {
        return PROGRAM_RUN.equals(this.privilegeId);
    }

    public String getPrivilegeId() {
        return privilegeId;
    }

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public void setPrivilegeId(String privilegeId) {
        this.privilegeId = privilegeId;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }

    public int getProgramPrivilegeId() {
        return programPrivilegeId;
    }

    public void setProgramPrivilegeId(int programPrivilegeId) {
        this.programPrivilegeId = programPrivilegeId;
    }
}
