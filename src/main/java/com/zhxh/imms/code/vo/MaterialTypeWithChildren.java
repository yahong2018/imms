package com.zhxh.imms.code.vo;

import com.zhxh.core.data.ParentChildVO;
import com.zhxh.imms.code.entity.MaterialType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaterialTypeWithChildren extends MaterialType implements ParentChildVO {
    private Object[] children;
}
