package com.zhxh.imms.code.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.AutoGeneration;
import com.zhxh.core.data.meta.annotation.CheckUnique;
import com.zhxh.core.data.meta.annotation.DataTable;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@DataTable("uom")
@Getter
@Setter
public class Uom extends EntityObject {
    @CheckUnique
    private String uomNo;
    private String uomName;
    private String uomDescription;
}
