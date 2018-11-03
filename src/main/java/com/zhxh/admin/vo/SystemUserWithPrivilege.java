package com.zhxh.admin.vo;

import com.zhxh.admin.entity.RolePrivilege;
import com.zhxh.admin.entity.SystemUser;

import java.util.List;

public class SystemUserWithPrivilege extends SystemUser {
    private List<RolePrivilege> privilegeList;

    public List<RolePrivilege> getPrivilegeList() {
        return privilegeList;
    }

    public void setPrivilegeList(List<RolePrivilege> privilegeList) {
        this.privilegeList = privilegeList;
    }
}
