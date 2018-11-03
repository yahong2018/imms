package com.zhxh.admin.logic;

import com.zhxh.admin.dao.SystemUserDAO;
import com.zhxh.admin.entity.SystemUser;
import com.zhxh.admin.misc.SessionManager;
import com.zhxh.core.utils.StringUtilsExt;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Iterator;

import static com.zhxh.core.exception.ErrorCode.ERROR_LOGIN_ACCOUNT_DISABLED;
import static com.zhxh.core.exception.ErrorCode.ERROR_LOGIN_ACCOUNT_ERROR;
import static com.zhxh.core.exception.ExceptionManager.throwException;

@Component("authenticateLogic")
public class AuthenticateLogic {
    @Resource(name = "systemUserDAO")
    private SystemUserDAO systemUserDAO;

    public SystemUser getSessionLogin(HttpSession session) {
        return (SystemUser) session.getAttribute(CURRENT_LOGIN_STORED_ID);
    }

    public static SystemUser getCurrentLogin() {
        if (SessionManager.getCurrentSession() == null) {
            return null;
        }
        HttpSession session = SessionManager.getCurrentSession();
        SystemUser result = (SystemUser) session.getAttribute(CURRENT_LOGIN_STORED_ID);
        return result;
    }

    public void authenticate(SystemUser user) throws Exception {
        //1.验证账号和密码
        SystemUser dbUser = systemUserDAO.getById(user.getUserId());
        String md5 = StringUtilsExt.getMd5(user.getPassword());
        if (dbUser == null || !md5.equals(dbUser.getPassword())) {
            throwException(ERROR_LOGIN_ACCOUNT_ERROR);
        }
        if (dbUser.isDisabled()) {
            throwException(ERROR_LOGIN_ACCOUNT_DISABLED);
        }
        //2.更新Session
        setCurrentLogin(dbUser);
        //3.更新数据库
        dbUser.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
        dbUser.setOnline(true);

        systemUserDAO.update(dbUser);
    }

    public synchronized void setCurrentLogin(SystemUser currentLogin) {
        SessionManager.getCurrentSession().setAttribute(CURRENT_LOGIN_STORED_ID, currentLogin);
    }

    public synchronized void kickOffUser() throws Exception {
        SystemUser user = getCurrentLogin();
        this.kickOffUser(user);
    }

    public synchronized void kickOffUser(SystemUser login) throws Exception {
        HttpSession session = this.getUserSession(login);
        //1.移除Session
        session.removeAttribute(CURRENT_LOGIN_STORED_ID);
        //2.更新数据库
        SystemUser dbItem = this.systemUserDAO.getById(login.getUserId());
        dbItem.setOnline(false);
        dbItem.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
        systemUserDAO.update(dbItem);
    }

    public static HttpSession getUserSession(SystemUser user) {
        HashSet sessions = SessionManager.getSessionList();
        Iterator<HttpSession> iterator = sessions.iterator();
        while (iterator.hasNext()) {
            HttpSession session = iterator.next();
            SystemUser theUser = (SystemUser) session.getAttribute(CURRENT_LOGIN_STORED_ID);
            if(theUser==null) {
                continue;
            }
            if (user.getUserId().equals(theUser.getUserId())) {
                return session;
            }
        }
        return null;
    }

    protected static final String CURRENT_LOGIN_STORED_ID = "{9D929EBB-1006-4597-A5E0-F159BB93AA60}";
}
