package com.zhxh.imms.code.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.CheckUnique;
import com.zhxh.core.data.meta.TreeTable;
import com.zhxh.core.data.meta.TreeTableParentKey;

@TreeTable
public class Size implements EntityObject {
    private String rowId;

    @CheckUnique
    private String sizeNo;

    private String sizeName;
    private String description;

    @TreeTableParentKey
    private String parentSizeId;

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
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

    public String getParentSizeId() {
        return parentSizeId;
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

    public void setParentSizeId(String parentSizeId) {
        this.parentSizeId = parentSizeId;
    }
}
