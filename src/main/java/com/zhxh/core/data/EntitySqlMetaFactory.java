package com.zhxh.core.data;

import com.zhxh.core.data.meta.DataTable;
import com.zhxh.core.env.SysEnv;
import org.apache.ibatis.mapping.ResultMap;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.HashMap;
import java.util.Map;

public class EntitySqlMetaFactory {
    public void init() {
        for (Map.Entry<String, String> entry : SysEnv.getEntityTableMappingHolder().entrySet()) {
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
        if(clazz==null){
            return null;
        }

        String key = clazz.getCanonicalName();
        if (!metaMap.containsKey(key)) {
            Class supperClass = clazz.getSuperclass();
            EntitySqlMeta parentMeta = getEntitySqlMeta(supperClass);
            if (parentMeta != null) {
                EntitySqlMeta selfMeta = EntitySqlMetaFactory.sqlMetaCreator.createSqlMeta(clazz);
                selfMeta.copyFrom(parentMeta);
                metaMap.put(key,selfMeta);

                return selfMeta;
            }

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
        ResultMap resultMap = EntitySqlMetaFactory.sqlSession.getConfiguration().getResultMap(key);
        meta.setResultMap(resultMap);
        meta.initSql();

        metaMap.put(key, meta);

        return meta;
    }

    public void registerSqlMeta(Class<?> clazz,EntitySqlMeta meta){
        String key = clazz.getCanonicalName();
        metaMap.put(key,meta);
    }

    private static SqlSessionTemplate sqlSession;
    protected final static Map<String, EntitySqlMeta> metaMap = new HashMap<>();

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        EntitySqlMetaFactory.sqlSession = sqlSession;
    }

    private static SqlMetaCreator sqlMetaCreator;

    public void setSqlMetaCreator(SqlMetaCreator sqlMetaCreator) {
        EntitySqlMetaFactory.sqlMetaCreator = sqlMetaCreator;
    }
}
