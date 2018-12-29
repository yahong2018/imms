package com.zhxh.imms.code.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.DataTable;
import lombok.Getter;
import lombok.Setter;

@DataTable("code_seed")
@Getter
@Setter
public class CodeSeed extends EntityObject {
    private String seedNo;
    private String seedName;
    private int initialValue;
    private String prefix;
    private String postfix;
    private int totalLength;
}
