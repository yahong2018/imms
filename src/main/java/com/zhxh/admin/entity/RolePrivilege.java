package com.zhxh.admin.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.DataTable;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@DataTable("role_privilege")
@Getter
@Setter
public class RolePrivilege extends EntityObject {
    private String programPrivilegeId;
    private String roleId;
    private String programId;
    private String privilegeCode;

    public RolePrivilege(){}
    public RolePrivilege(String roleId, ProgramPrivilege programPrivilege){
        this.setRoleId(roleId);
        this.setPrivilegeCode(programPrivilege.getPrivilegeCode());
        this.setProgramId(programPrivilege.getProgramId());
        this.setProgramPrivilegeId(programPrivilege.getRecordId());
    }
}
