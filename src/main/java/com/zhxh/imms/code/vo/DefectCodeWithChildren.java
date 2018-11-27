package com.zhxh.imms.code.vo;

import com.zhxh.core.data.ParentChildVO;
import com.zhxh.imms.code.entity.DefectCode;

public class DefectCodeWithChildren extends DefectCode implements ParentChildVO<DefectCode> {
    private DefectCode[] children;

    public DefectCode[] getChildren() {
        return children;
    }

    public void setChildren(DefectCode[] children) {
        this.children = children;
    }
}
