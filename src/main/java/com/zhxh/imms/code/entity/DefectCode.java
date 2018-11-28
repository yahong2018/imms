package com.zhxh.imms.code.entity;
import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.CheckUnique;
import com.zhxh.core.data.meta.TreeTableParentKey;
import com.zhxh.core.data.meta.TreeTable;

@TreeTable
public class DefectCode implements EntityObject {
    @CheckUnique
    private String defectCodeNo;

    private String defectCodeName;
    private String description;

    @TreeTableParentKey
    private String parentDefectId;

    private String rowId;

    public String getRowId() {
        return rowId;
    }
    public void setRowId(String rowId) {
        this.rowId = rowId;
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

    public String getParentDefectId() {
        return parentDefectId;
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

    public void setParentDefectId(String parentDefectId) {
        this.parentDefectId = parentDefectId;
    }
}
