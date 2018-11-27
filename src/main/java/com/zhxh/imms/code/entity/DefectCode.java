package com.zhxh.imms.code.entity;

import com.zhxh.core.data.EntityObject;

public class DefectCode extends EntityObject {
    private long id;
    private String defectCodeNo;
    private String defectCodeName;
    private String description;
    private long parentDefectId;

    public long getId() {
        return id;
    }

    public String getDefectCodeNo() {
        return defectCodeNo;
    }

    public String getDefectCodeName() {
        return defectCodeName;
    }

    public String getDescription() {
        return description;
    }

    public long getParentDefectId() {
        return parentDefectId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDefectCodeNo(String defectCodeNo) {
        this.defectCodeNo = defectCodeNo;
    }

    public void setDefectCodeName(String defectCodeName) {
        this.defectCodeName = defectCodeName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setParentDefectId(long parentDefectId) {
        this.parentDefectId = parentDefectId;
    }
}
