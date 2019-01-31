package com.zhxh.imms.code.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.DataTableConfiguration;
import lombok.Getter;
import lombok.Setter;

@DataTableConfiguration("code_seed")
@Getter
@Setter
public class CodeSeed extends EntityObject<Long> {
    private String seedNo;
    private String seedName;
    private int initialValue;
    private String prefix;
    private String postfix;
    private int totalLength;
}
