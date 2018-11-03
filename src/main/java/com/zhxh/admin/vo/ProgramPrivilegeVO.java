package com.zhxh.admin.vo;

import com.zhxh.admin.entity.ProgramPrivilege;

public class ProgramPrivilegeVO extends ProgramPrivilege {
    private boolean checked;
    private String dataType;

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
