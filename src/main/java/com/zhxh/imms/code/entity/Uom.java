package com.zhxh.imms.code.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.CheckUnique;
import com.zhxh.core.data.meta.annotation.DataTableConfiguration;
import lombok.Getter;
import lombok.Setter;

@DataTableConfiguration("uom")
@Getter
@Setter
public class Uom extends EntityObject<Long> {
    @CheckUnique
    private String uomNo;
    private String uomName;
    private String description;
}
