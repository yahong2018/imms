package com.zhxh.imms.code.entity;

import com.zhxh.core.data.EntityObject;

public class Size implements EntityObject {
    private long id;
    private String sizeNo;
    private String sizeName;
    private String description;
    private long parentSizeId;

    public long getId() {
        return id;
    }

    public String getSizeNo() {
        return sizeNo;
    }

    public String getSizeName() {
        return sizeName;
    }

    public String getDescription() {
        return description;
    }

    public long getParentSizeId() {
        return parentSizeId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSizeNo(String sizeNo) {
        this.sizeNo = sizeNo;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setParentSizeId(long parentSizeId) {
        this.parentSizeId = parentSizeId;
    }
}
