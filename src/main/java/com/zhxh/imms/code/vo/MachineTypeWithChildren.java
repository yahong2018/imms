package com.zhxh.imms.code.vo;

import com.zhxh.core.data.ParentChildVO;
import com.zhxh.imms.code.entity.MachineType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MachineTypeWithChildren extends MachineType implements ParentChildVO {
    private Object[] children;
}
