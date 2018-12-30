package com.zhxh.imms.code.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@DataTable("material_type")
@TreeTable
@Getter
@Setter
public class MaterialType extends EntityObject {
    @CheckUnique
    private String materialTypeNo;
    private String materialTypeName;
    private String description;
    @TreeTableParentKey
    private String parentMaterialTypeId;
    private String materialTypeNoPath;
    private String materialTypeNamePath;
}
