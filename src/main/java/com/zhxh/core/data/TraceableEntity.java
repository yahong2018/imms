package com.zhxh.core.data;


import com.zhxh.admin.logic.AuthenticateLogic;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class TraceableEntity extends EntityObject {
    public static void fillCreateInfo(TraceableEntity entity){
        entity.setCreateBy(AuthenticateLogic.getCurrentLogin().getRecordId());
        entity.setCreateDate(new Date());
    }

    public static void fillUpdateInfo(TraceableEntity entity){
        entity.setUpdateBy(AuthenticateLogic.getCurrentLogin().getRecordId());
        entity.setUpdateDate(new Date());
    }

    private Date createDate;
    private Date updateDate;
    private String createBy;
    private String updateBy;
    private int optLock;

    static final List<String> internal_fields = new ArrayList<>();
    static {
        internal_fields.add("createBy");
        internal_fields.add("createDate");
        internal_fields.add("updateBy");
        internal_fields.add("updateDate");
        internal_fields.add("optLock");
//        internal_fields.add("delFlag");
    }
}
