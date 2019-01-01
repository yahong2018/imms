package com.zhxh.imms.order.vo;

import com.zhxh.imms.order.entity.RequirementOrder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequirementOrderVO extends RequirementOrder {
    private String materialNo;
    private String materialName;
    private String workCenterNo;
    private String workCenterName;
    private String planNo;
    private String plantName;
}
