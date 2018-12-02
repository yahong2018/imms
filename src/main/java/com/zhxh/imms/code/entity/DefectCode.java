package com.zhxh.imms.code.entity;
import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.CheckUnique;
import com.zhxh.core.data.meta.annotation.TreeTableParentKey;
import com.zhxh.core.data.meta.annotation.TreeTable;

import java.util.UUID;

@TreeTable
public class DefectCode implements EntityObject {
    @CheckUnique
    private String defectCodeNo;

    private String defectCodeName;
    private String defectCodeDescription;

    @TreeTableParentKey
    private String parentDefectCodeId;

    private String defectCodeId;

    public DefectCode(){
        this.defectCodeId = UUID.randomUUID().toString();
    }

    public String getDefectCodeId() {
        return defectCodeId;
    }

    public void setDefectCodeId(String defectCodeId) {
        this.defectCodeId = defectCodeId;
    }

    public String getDefectCodeNo() {
        return defectCodeNo;
    }

    public String getDefectCodeName() {
        return defectCodeName;
    }

    public void setDefectCodeNo(String defectCodeNo) {
        this.defectCodeNo = defectCodeNo;
    }

    public void setDefectCodeName(String defectCodeName) {
        this.defectCodeName = defectCodeName;
    }


    public String getParentDefectCodeId() {
        return parentDefectCodeId;
    }

    public String getDefectCodeDescription() {
        return defectCodeDescription;
    }

    public void setDefectCodeDescription(String defectCodeDescription) {
        this.defectCodeDescription = defectCodeDescription;
    }

    public void setParentDefectCodeId(String parentDefectCodeId) {
        this.parentDefectCodeId = parentDefectCodeId;
    }
}
