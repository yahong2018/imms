package com.zhxh.admin.entity;

import com.zhxh.core.data.EntityObject;
import com.zhxh.core.data.meta.DataTable;
import com.zhxh.core.data.validate.FixedLength;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;

@DataTable(tableName = "system_user")
public class SystemUser extends EntityObject {
    public final static int USER_STATUS_NORMAL = 0;
    public final static int USER_STATUS_DISABLED = 1;
    public final static String DEFAULT_PASSWORD = "888888";

    @FixedLength(length = 6)
    private String userId;

    @NotEmpty()
    @Length(max = 20)
    private String userName;

    @NotEmpty
    @Length(max = 50)
    private String password;

    private int userStatus;

    @NotEmpty
    @Email
    private String email;

    private boolean online;
    private Timestamp lastLoginTime;

    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public boolean isOnline() {
        return online;
    }
    public void setOnline(boolean online) {
        this.online = online;
    }
    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public boolean isDisabled() {
        return this.getUserStatus() == USER_STATUS_DISABLED;
    }
}
