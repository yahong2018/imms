package com.zhxh.imms.code.vo;

import com.zhxh.core.data.ParentChildVO;
import com.zhxh.imms.code.entity.DefectCode;

public class DefectCodeWithChildren extends DefectCode  implements ParentChildVO {
    private Object[] children;

    public Object[] getChildren() {
        return children;
    }

    public void setChildren(Object[] children) {
        this.children = children;
    }
}
