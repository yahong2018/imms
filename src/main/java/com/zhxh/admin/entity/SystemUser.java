package com.zhxh.admin.entity;

import com.zhxh.core.data.Code;
import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.annotation.DataTable;
import com.zhxh.core.data.validate.FixedLength;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;

@DataTable("system_user")
@Getter
@Setter
public class SystemUser extends EntityObject {
    public final static String DEFAULT_PASSWORD = "888888";

    private String userCode;
    private String userName;
    private String password;
    private Code   userStatus;
    private String email;
    private boolean online;
    private Timestamp lastLoginTime;

    public boolean isDisabled() {
        return this.userStatus == Code.DISABLED;
    }
}
