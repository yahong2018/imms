package com.zhxh.imms.factory.vo;

import com.zhxh.imms.factory.entity.Line;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LineVO extends Line {
    private String startMainLineNo;
    private String endMainLineNo;
    private String workCenterNo;
    private String workStationName;
}
