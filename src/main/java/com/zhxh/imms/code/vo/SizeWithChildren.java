package com.zhxh.imms.code.vo;

import com.zhxh.core.data.ParentChildVO;
import com.zhxh.imms.code.entity.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SizeWithChildren extends Size implements ParentChildVO {
    private Object[] children;
}
