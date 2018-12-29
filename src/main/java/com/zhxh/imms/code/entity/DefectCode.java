package com.zhxh.imms.code.entity;
import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@DataTable("defect_code")
@TreeTable
@Getter
@Setter
public class DefectCode extends EntityObject {
    @CheckUnique
    private String defectCodeNo;
    private String defectCodeName;
    private String defectCodeDescription;
    @TreeTableParentKey
    private String parentDefectCodeId;
    private String defectCodeNoPath;
    private String defectCodeNamePath;
}
