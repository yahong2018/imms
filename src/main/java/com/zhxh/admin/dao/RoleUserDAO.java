package com.zhxh.admin.dao;

import com.zhxh.admin.entity.RoleUser;
import com.zhxh.admin.entity.SystemRole;
import com.zhxh.admin.entity.SystemUser;
import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.data.EntitySqlMeta;
import com.zhxh.core.data.EntitySqlMetaFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.zhxh.core.exception.ErrorCode.ERROR_DATA_ALREADY_EXISTS;
import static com.zhxh.core.exception.ExceptionHelper.*;

@Component("roleUserDAO")
public class RoleUserDAO extends BaseDAOWithEntity<RoleUser> {
    public int revokeUserAllRoles(String userId){
        EntitySqlMeta sqlMeta = EntitySqlMetaFactory.getEntitySqlMeta(this.clazz);        	
        String sql = sqlMeta.buildDeleteByWhereSql("  where user_id = #{userId}");
        Map parameters = new HashMap();
        parameters.put("userId",userId);

        return this.executeNoneQuery(sql,parameters);
    }

    @Override
    public int insert(Object item) throws Exception {
        super.verifyBean(item, DATA_OPERATION_INSERT);

        RoleUser roleUser = (RoleUser) item;
        RoleUser dbItem = this.getByUserIdAndRoleId(roleUser.getUserId(), roleUser.getRoleId());
        if (dbItem != null) {
            throwException(ERROR_DATA_ALREADY_EXISTS);
        }
        return this.getSqlHelper().getSqlSession().insert(SQL_INSERT_ROLE_USER, item);
    }

    public int delete(String userId, String roleId) {
        Map parameters = new HashMap();
        parameters.put("userId", userId);
        parameters.put("roleId", roleId);

        return this.getSqlHelper().getSqlSession().delete(SQL_DELETE_ROLE_USER, parameters);
    }

    public RoleUser getByUserIdAndRoleId(String userId, String roleId) {
        Map parameters = new HashMap();
        parameters.put("userId", userId);
        parameters.put("roleId", roleId);

        String where = "role_id=#{roleId} and user_id=#{user_id}";

        return this.getOne(where, parameters);
    }

    public List<SystemRole> getUserRoles(String userId) {
        Map map = new HashMap();
        map.put("userId", userId);

        return this.sqlHelper.getSqlSession().selectList(SQL_GET_USER_ROLES, map);
    }

    public List<SystemUser> getRoleUsers(String roleId) {
        Map map = new HashMap();
        map.put("roleId", roleId);

        return this.sqlHelper.getSqlSession().selectList(SQL_GET_ROLE_USERS, map);
    }

    protected final static String SQL_GET_ROLE_USERS = "com.zhxh.admin.dao.GET_ROLE_USERS";
    protected final static String SQL_GET_USER_ROLES = "com.zhxh.admin.dao.GET_USER_ROLES";
    protected final static String SQL_INSERT_ROLE_USER = "com.zhxh.admin.dao.INSERT_ROLE_USER";
    protected final static String SQL_DELETE_ROLE_USER = "com.zhxh.admin.dao.DELETE_ROLE_USER";
}
