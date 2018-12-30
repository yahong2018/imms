package com.zhxh.imms.factory.vo;

import com.zhxh.imms.factory.entity.Operator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperatorVO extends Operator {
    private String operatorUserCode;
    private String operatorName;
    private String supervisorUserCode;
    private String supervisorName;
}
