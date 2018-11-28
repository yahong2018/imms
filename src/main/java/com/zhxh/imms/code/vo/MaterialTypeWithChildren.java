package com.zhxh.imms.code.vo;

import com.zhxh.core.data.ParentChildVO;
import com.zhxh.imms.code.entity.MaterialType;

public class MaterialTypeWithChildren extends MaterialType implements ParentChildVO {
    private Object[] children;

    public Object[] getChildren() {
        return children;
    }

    public void setChildren(Object[] children) {
        this.children = children;
    }
}
