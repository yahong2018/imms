package com.zhxh.core.data;

import com.zhxh.core.env.SysEnv;
import com.zhxh.core.exception.BusinessError;
import com.zhxh.core.utils.BeanUtils;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.zhxh.core.exception.ErrorCode.ERROR_DATA_ALREADY_EXISTS;
import static com.zhxh.core.exception.ErrorCode.ERROR_DATA_NOT_EXISTS;
import static com.zhxh.core.exception.ExceptionManager.throwException;

public class BaseDAO {
    public static final int DATA_OPERATION_INSERT = 1;
    public static final int DATA_OPERATION_UPDATE = 2;
    public static final int DATA_OPERATION_DELETE = 3;
    public static final int DATA_OPERATION_GET = 4;

    @Resource(name = "sqlHelper")
    protected SqlHelper sqlHelper;
    @Resource(name = "validator")
    private Validator validator;

    public BaseDAO() {
    }

    public List getAll(Class clazz) {
        return this.getList(clazz, null);
    }

    public List getList(Class clazz, Map listMap) {
        return this.getList(clazz, listMap, null);
    }

    public List getList(Class clazz, Map listMap, Map parameter) {
        return sqlHelper.getList(clazz, listMap, parameter);
    }

    public List getPageList(Class clazz, Map listMap, Map parameters) {
        return sqlHelper.getPageList(clazz, listMap, parameters);
    }

    public int getPageListCount(Class clazz, Map listMap, Map parameters) {
        return sqlHelper.getPageListCount(clazz, listMap, parameters);
    }

    public int getPageListCount(Class clazz, Map listMap) {
        return this.getPageListCount(clazz, listMap, null);
    }

    public List getPageList(Class clazz, Map listMap) {
        return this.getPageList(clazz, listMap, null);
    }

    public String getIdLabel(Class clazz) {
        return this.getPropertyLabel(this.getPropertyFullName(clazz, EntitySqlMetaFactory.getEntitySqlMeta(clazz).getKeyProperty()));
    }

    public int insert(Object item) throws Exception {
        if(item instanceof TrackableEntity){
            TrackableEntity.fillCreateInfo((TrackableEntity)item);
        }

        if (this.exists(item)) {
            String keyProperty = getKeyProperty(item.getClass());
            Object keyValue = BeanUtils.getValue(item, keyProperty);
            String idLabel = this.getIdLabel(item.getClass());

            throwException(ERROR_DATA_ALREADY_EXISTS, idLabel, keyValue);
        }
        this.verify(item, DATA_OPERATION_INSERT);

        return this.doInternalInsert(item);
    }

    public int update(Object item) throws Exception {
        if(item instanceof TrackableEntity){
            TrackableEntity.fillUpdateInfo((TrackableEntity) item);
        }

        if (!this.exists(item)) {
            String keyProperty = getKeyProperty(item.getClass());
            Object keyValue = BeanUtils.getValue(item, keyProperty);
            String idLabel = this.getIdLabel(item.getClass());

            throwException(ERROR_DATA_NOT_EXISTS, idLabel, keyValue);
        }
        this.verify(item, DATA_OPERATION_UPDATE);

        return this.doInternalUpdate(item);
    }


    public int delete(Object item) throws Exception {
        if (!this.exists(item)) {
            String keyProperty = getKeyProperty(item.getClass());
            String idLabel = this.getIdLabel(item.getClass());
            Object keyValue = BeanUtils.getValue(item, keyProperty);

            throwException(ERROR_DATA_NOT_EXISTS, idLabel, keyValue);
        }
        this.verify(item, DATA_OPERATION_DELETE);

        return this.doInternalDelete(item);
    }

    public List executeList(Class clazz, String sql, Map parameters) {
        return this.sqlHelper.executeList(clazz, sql, parameters);
    }

    public int executeNoneQuery(String sql, Map parameters) {
        return this.sqlHelper.executeNoneQuery(sql, parameters);
    }

    public List executeList(Class clazz, String sql) {
        return this.executeList(clazz, sql, null);
    }

    public int executeNoneQuery(String sql) {
        return this.executeNoneQuery(sql, null);
    }

    public boolean exists(Object item) {
        EntitySqlMeta meta = EntitySqlMetaFactory.getEntitySqlMeta(item.getClass());
        Object id = BeanUtils.getValue(item, meta.getKeyProperty());
        Object dbItem = this.getById(item.getClass(), id);
        return dbItem != null;
    }

    protected String getKeyProperty(Class clazz) {
        EntitySqlMeta meta = EntitySqlMetaFactory.getEntitySqlMeta(clazz);
        return meta.getKeyProperty();
    }

    public Object getById(Class clazz, Object id) {
        EntitySqlMeta meta = EntitySqlMetaFactory.getEntitySqlMeta(clazz);
        String keyAssign = meta.getFieldsAssigns().get(meta.getKeyColumn());
        Map listMap = new HashMap();
        listMap.put("where", keyAssign);
        String sql = meta.getSelectSql(listMap);
        Map parameters = new HashMap();
        parameters.put(meta.getKeyProperty(), id);
        Object dbItem = sqlHelper.executeScalar(clazz, sql, parameters);
        return dbItem;
    }

    public <T> void verifyBean(T item, int operationCode) throws BusinessError {
        Set<ConstraintViolation<T>> errorSet = validator.validate(item);
        StringBuffer msgBuffer = new StringBuffer();
        for (ConstraintViolation<T> error : errorSet) {
            String fieldName = this.getPropertyFullName(item.getClass(), error.getPropertyPath().toString());
            String fieldLabel = this.getPropertyLabel(fieldName);

            msgBuffer.append(fieldLabel).append(error.getMessage()).append("\n");
        }
        if (errorSet.size() > 0) {
            throw new BusinessError(msgBuffer.toString());
        }
    }

    protected String getPropertyFullName(Class clazz, String shortPropertyName) {
        if(TrackableEntity.class.isAssignableFrom(clazz)){
            if(TrackableEntity.internal_fields.contains(shortPropertyName)) {
                return TrackableEntity.class.getCanonicalName() + "." + shortPropertyName;
            }
        }
        return clazz.getCanonicalName() + "." + shortPropertyName;
    }

    protected String getPropertyLabel(String property) {
        String fieldLabel = SysEnv.getCurrent().getFieldsPropertyConfigurer().get(property);
        return fieldLabel;
    }

    public void verify(Object item, int operationCode) throws BusinessError {
        this.verifyBean(item, operationCode);
    }

    protected int doInternalInsert(Object item) {
        return sqlHelper.insert(item);
    }

    protected int doInternalUpdate(Object item) {
        return sqlHelper.update(item);
    }

    protected int doInternalDelete(Object item) {
        return sqlHelper.delete(item);
    }

    public SqlHelper getSqlHelper() {
        return sqlHelper;
    }
}
