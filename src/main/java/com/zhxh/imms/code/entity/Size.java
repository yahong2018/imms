package com.zhxh.imms.code.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.AutoGeneration;
import com.zhxh.core.data.meta.annotation.CheckUnique;
import com.zhxh.core.data.meta.annotation.TreeTable;
import com.zhxh.core.data.meta.annotation.TreeTableParentKey;

import java.util.UUID;

@TreeTable
public class Size implements EntityObject {
    @AutoGeneration
    private String sizeId;

    @CheckUnique
    private String sizeNo;

    private String sizeName;
    private String sizeDescription;

    @TreeTableParentKey
    private String parentSizeId;

    private String sizeNoPath;
    private String sizeNamePath;

    public String getSizeNoPath() {
        return sizeNoPath;
    }

    public String getSizeNamePath() {
        return sizeNamePath;
    }

    public void setSizeNoPath(String sizeNoPath) {
        this.sizeNoPath = sizeNoPath;
    }

    public void setSizeNamePath(String sizeNamePath) {
        this.sizeNamePath = sizeNamePath;
    }

    public String getSizeId() {
        return sizeId;
    }

    public void setSizeId(String sizeId) {
        this.sizeId = sizeId;
    }

    public String getSizeNo() {
        return sizeNo;
    }

    public String getSizeName() {
        return sizeName;
    }

    public String getParentSizeId() {
        return parentSizeId;
    }

    public void setSizeNo(String sizeNo) {
        this.sizeNo = sizeNo;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public void setParentSizeId(String parentSizeId) {
        this.parentSizeId = parentSizeId;
    }

    public String getSizeDescription() {
        return sizeDescription;
    }

    public void setSizeDescription(String sizeDescription) {
        this.sizeDescription = sizeDescription;
    }
}
