package com.zhxh.imms.code.entity;

import com.zhxh.core.data.Entity;
import com.zhxh.core.data.meta.annotation.CheckUnique;
import com.zhxh.core.data.meta.annotation.DataTableConfiguration;
import lombok.Getter;
import lombok.Setter;

@DataTableConfiguration("uom")
@Getter
@Setter
public class Uom extends Entity<Long> {
    @CheckUnique
    private String uomNo;
    private String uomName;
    private String description;
}
