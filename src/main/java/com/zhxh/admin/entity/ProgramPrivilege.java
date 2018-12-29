package com.zhxh.admin.entity;

import com.zhxh.core.data.Code;
import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.DataTable;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@DataTable("program_privilege")
@Getter
@Setter
public class ProgramPrivilege extends EntityObject {
    private String programId;
    private String privilegeCode;
    private String privilegeName;

    public boolean isInsertPrivilege() {
        return Code.DATA_INSERT.equals(this.privilegeCode);
    }

    public boolean isUpdatePrivilege() {
        return Code.DATA_UPDATE.equals(this.privilegeCode);
    }

    public boolean isDeletePrivilege() {
        return Code.DATA_DELETE.equals(this.privilegeCode);
    }

    public boolean isRunPrivilege() {
        return Code.PROGRAM_RUN.equals(this.privilegeCode);
    }
}
