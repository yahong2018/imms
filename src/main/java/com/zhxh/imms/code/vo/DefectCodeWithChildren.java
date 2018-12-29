package com.zhxh.imms.code.vo;

import com.zhxh.core.data.ParentChildVO;
import com.zhxh.imms.code.entity.DefectCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DefectCodeWithChildren extends DefectCode  implements ParentChildVO {
    private Object[] children;
}
