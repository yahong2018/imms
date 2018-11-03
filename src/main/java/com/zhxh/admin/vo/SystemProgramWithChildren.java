package com.zhxh.admin.vo;

import com.zhxh.admin.entity.SystemProgram;

public class SystemProgramWithChildren extends SystemProgram {
    private SystemProgram[] children;

    public boolean isLeaf() {
        return children == null || children.length == 0;
    }
    public boolean isExpanded(){
        return !this.isLeaf();
    }

    public SystemProgram[] getChildren() {
        return children;
    }

    public void setChildren(SystemProgram[] children) {
        this.children = children;
    }
}
