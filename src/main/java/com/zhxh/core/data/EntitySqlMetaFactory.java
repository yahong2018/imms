package com.zhxh.core.data;

import com.zhxh.core.data.meta.DataTable;
import com.zhxh.core.data.meta.OracleMeta;
import org.apache.ibatis.mapping.ResultMap;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.HashMap;
import java.util.Map;

public class EntitySqlMetaFactory {
    public void init() {
        for (Map.Entry<String, String> entry : this.initEntry.entrySet()) {
            String className = entry.getKey();
            String tableName = entry.getValue();

            try {
                Class clazz = Class.forName(className);
                EntitySqlMetaFactory.initMeta(clazz, tableName);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static EntitySqlMeta getEntitySqlMeta(Class<?> clazz) {
        String key = clazz.getCanonicalName();
        if (!metaMap.containsKey(key)) {
            DataTable dataTable = clazz.getAnnotation(DataTable.class);
            if (dataTable == null) {
                return null;
            }
            String tableName = dataTable.tableName();

            return initMeta(clazz, tableName);
        }
        return metaMap.get(key);
    }

    public synchronized static EntitySqlMeta initMeta(Class<?> clazz, String tableName) {
        String key = clazz.getCanonicalName();
        EntitySqlMeta meta = EntitySqlMetaFactory.sqlMetaCreator.createSqlMeta(clazz);
        meta.setTableName(tableName);
        ResultMap resultMap = EntitySqlMetaFactory.getSqlSession().getConfiguration().getResultMap(key);
        meta.setResultMap(resultMap);
        meta.buildSql();

        metaMap.put(key, meta);

        return meta;
    }

    protected EntitySqlMeta createSqlMeta(Class<?> clazz) {
        return new OracleMeta();
    }

    private Map<String, String> initEntry;

    public Map<String, String> getInitEntry() {
        return initEntry;
    }

    public void setInitEntry(Map<String, String> initEntry) {
        this.initEntry = initEntry;
    }

    private static SqlSessionTemplate sqlSession;
    protected final static Map<String, EntitySqlMeta> metaMap = new HashMap<>();

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        EntitySqlMetaFactory.sqlSession = sqlSession;
    }

    public static SqlSessionTemplate getSqlSession() {
        return EntitySqlMetaFactory.sqlSession;
    }

    private static SqlMetaCreator sqlMetaCreator;

    public void setSqlMetaCreator(SqlMetaCreator sqlMetaCreator) {
        EntitySqlMetaFactory.sqlMetaCreator = sqlMetaCreator;
    }
}
