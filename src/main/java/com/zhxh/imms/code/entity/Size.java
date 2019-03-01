package com.zhxh.imms.code.entity;

import com.zhxh.core.data.Entity;
import com.zhxh.core.data.meta.annotation.*;
import lombok.Getter;
import lombok.Setter;

@DataTableConfiguration("size")
@TreeTable
@Getter
@Setter
public class Size extends Entity<Long> {
    @CheckUnique
    private String sizeNo;
    private String sizeName;
    private String description;
    @TreeTableParentKey
    private String parentSizeId;
    private String sizeNoPath;
    private String sizeNamePath;
}
