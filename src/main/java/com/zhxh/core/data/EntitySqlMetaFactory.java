package com.zhxh.core.data;

import com.zhxh.core.data.meta.annotation.DataTable;
import com.zhxh.core.env.SysEnv;
import org.apache.ibatis.mapping.ResultMap;
import org.mybatis.spring.SqlSessionTemplate;

import javax.annotation.Resource;
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
        if (clazz == null) {
            return null;
        }

        String key = clazz.getCanonicalName();
        if (!metaMap.containsKey(key)) {
            Class supperClass = clazz.getSuperclass();
            EntitySqlMeta parentMeta = getEntitySqlMeta(supperClass);
            if (parentMeta != null) {
                EntitySqlMeta selfMeta = EntitySqlMetaFactory.getSqlMetaCreator().createSqlMeta(clazz);
                selfMeta.copyFrom(parentMeta);
                metaMap.put(key, selfMeta);

                return selfMeta;
            }

            DataTable dataTable = clazz.getAnnotation(DataTable.class);
            if (dataTable == null) {
                return null;
            }
            String tableName = dataTable.value();

            return initMeta(clazz, tableName);
        }
        return metaMap.get(key);
    }

    public synchronized static EntitySqlMeta initMeta(Class<?> clazz, String tableName) {
        String key = clazz.getCanonicalName();
        EntitySqlMeta meta = EntitySqlMetaFactory.getSqlMetaCreator().createSqlMeta(clazz);
        meta.setTableName(tableName);
        ResultMap resultMap = EntitySqlMetaFactory.getSqlSession().getConfiguration().getResultMap(key);
        meta.setResultMap(resultMap);
        meta.initSql();

        metaMap.put(key, meta);

        return meta;
    }

    public void registerSqlMeta(Class<?> clazz, EntitySqlMeta meta) {
        String key = clazz.getCanonicalName();
        metaMap.put(key, meta);
    }

    private static SqlSessionTemplate sqlSession;
    private static SqlMetaCreator sqlMetaCreator;
    protected final static Map<String, EntitySqlMeta> metaMap = new HashMap<>();

    public synchronized static SqlSessionTemplate getSqlSession() {
        if (sqlSession == null) {
            sqlSession = (SqlSessionTemplate) SysEnv.getBean("sqlSession");
        }
        return sqlSession;
    }

    public synchronized static SqlMetaCreator getSqlMetaCreator() {
        if (sqlMetaCreator == null) {
            sqlMetaCreator = (SqlMetaCreator) SysEnv.getBean("sqlMetaCreator");
        }
        return sqlMetaCreator;
    }
}
