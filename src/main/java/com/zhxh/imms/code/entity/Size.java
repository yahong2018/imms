package com.zhxh.imms.code.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.*;
import lombok.Getter;
import lombok.Setter;

@DataTableConfiguration("size")
@TreeTable
@Getter
@Setter
public class Size extends EntityObject<Long> {
    @CheckUnique
    private String sizeNo;
    private String sizeName;
    private String description;
    @TreeTableParentKey
    private String parentSizeId;
    private String sizeNoPath;
    private String sizeNamePath;
}
