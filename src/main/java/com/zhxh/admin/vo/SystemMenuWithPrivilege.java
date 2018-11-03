package com.zhxh.admin.vo;

public class SystemMenuWithPrivilege extends SystemMenu {
    private boolean checked;
    private String dataType;

    @Override
    public boolean isFolder() {
        boolean result = super.isFolder();
        if(!result){
            result = (this.getChildren()!=null && this.getChildren().length>0);
        }
        return result;
    }

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
