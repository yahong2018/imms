package com.zhxh.core.data;


import com.zhxh.admin.logic.AuthenticateLogic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TrackableEntity extends EntityObject {
    public static void fillCreateInfo(TrackableEntity entity){
        entity.setCreateBy(AuthenticateLogic.getCurrentLogin().getUserId());
        entity.setCreateDate(new Date());
    }

    public static void fillUpdateInfo(TrackableEntity entity){
        entity.setUpdateBy(AuthenticateLogic.getCurrentLogin().getUserId());
        entity.setUpdateDate(new Date());
    }

    private Date createDate;
    private Date updateDate;
    private String createBy;
    private String updateBy;
    private int optLock;
    private int delFlag;

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }

    public int getOptLock() {
        return optLock;
    }

    public void setOptLock(int optLock) {
        this.optLock = optLock;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    static final List<String> internal_fields = new ArrayList<>();
    static {
        internal_fields.add("createBy");
        internal_fields.add("createDate");
        internal_fields.add("updateBy");
        internal_fields.add("updateDate");
        internal_fields.add("optLock");
        internal_fields.add("delFlag");
    }
}
