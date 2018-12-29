package com.zhxh.imms.material.vo;

import com.zhxh.imms.material.entity.Material;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaterialVO extends Material {
    private String materialTypeNo;
    private String materialTypeName;
    private String sizeNo;
    private String sizeName;
    private String uomNo;
    private String uomName;
}
