package com.zhxh.core.data;

import com.zhxh.core.exception.BusinessException;
import com.zhxh.core.utils.BeanUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.zhxh.core.exception.ErrorCode.ERROR_DATA_NOT_EXISTS;
import static com.zhxh.core.exception.ExceptionHelper.throwException;


public class BaseDAOWithEntity<T> extends BaseDAO implements Generic {
    protected Class clazz;

    public BaseDAOWithEntity() {
        Type t = this.getClass().getGenericSuperclass();
        this.clazz = (Class<T>) ((ParameterizedType) t).getActualTypeArguments()[0];
    }

    public List getAll() {
        return super.getAll(this.clazz);
    }

    public List getList(Map listMap) {
        return this.getList(listMap, null);
    }

    public List getList(Map listMap, Map parameter) {
        return super.getList(clazz,listMap, parameter);
    }

    public int getPageListCount(Map map, Map parameters) {
        return super.getPageListCount(this.clazz,map,parameters);
    }

    public List getPageList(Map map, Map parameters) {
        return super.getPageList(clazz,map, parameters);
    }
    public int getPageListCount(Map listMap) {
        return this.getPageListCount(listMap,null);
    }

    public List getPageList(Map listMap) {
        return this.getPageList(listMap, null);
    }

    public T getById(Object id) {
        return (T) this.getById(this.clazz, id);
    }

    public T getOne(String where) {
        return this.getOne(where, null);
    }

    public T getOne(String where, Map parameters) {
        EntitySqlMeta meta = EntitySqlMetaFactory.getEntitySqlMeta(clazz);
        Map listMap = new HashMap();
        listMap.put("where",where);
        String sql = meta.getSelectSql(listMap);
        T dbItem = sqlHelper.executeScalar(clazz, sql, parameters);
        return dbItem;
    }

    public String getIdLabel() {
        return super.getIdLabel(this.clazz);
    }

    public T verifyExistsById(Object id) throws Exception {
        T dbItem = this.getById(id);
        if (dbItem == null) {
            String idLabel = this.getIdLabel();
            throwException(ERROR_DATA_NOT_EXISTS, idLabel, id);
        }
        return dbItem;
    }
    
    public int deleteByWhere(String where,Map parameters) {
    	EntitySqlMeta meta = EntitySqlMetaFactory.getEntitySqlMeta(this.clazz);
    	String deleteSql = meta.getDeleteByWhereSql(where);
    	
    	return super.executeNoneQuery(deleteSql, parameters);
    }
    
    public int deleteById(Object id) throws Exception {
   	    T dbItem = this.verifyExistsById(id);
   	    return this.delete(dbItem);
    }

    public T verifyIsExists(T item) throws Exception {
        String idPropery = EntitySqlMetaFactory.getEntitySqlMeta(this.clazz).getKeyProperty();
        Object idValue = BeanUtils.getValue(item, idPropery);
        return this.verifyExistsById(idValue);
    }

    @Override
    public final void verify(Object item, int operationCode) throws BusinessException {
        super.verify(item, operationCode);
        this.doVerify((T) item, operationCode);
    }

    protected String getKeyProperty() {
        return super.getKeyProperty(this.clazz);
    }

    protected void doVerify(T item, int operationCode) {
    }

    @Override
    protected int doInternalInsert(Object item) {
        return this.doInsert((T) item);
    }

    @Override
    protected int doInternalUpdate(Object item) {
        return this.doUpdate((T) item);
    }

    @Override
    protected int doInternalDelete(Object item) {
        return this.doDelete((T) item);
    }

    protected int doInsert(T item) {
        return sqlHelper.insert(item);
    }

    protected int doUpdate(T item) {
        return sqlHelper.update(item);
    }

    protected int doDelete(T item) {
        return sqlHelper.delete(item);
    }

    protected String getPropertyFullName(String shortPropertyName) {
        return super.getPropertyFullName(this.clazz, shortPropertyName);
    }
}