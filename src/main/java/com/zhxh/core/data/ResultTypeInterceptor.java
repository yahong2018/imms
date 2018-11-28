package com.zhxh.core.data;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.mapping.ResultMapping;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Component
@Intercepts(@Signature(
        type = Executor.class,
        method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}))
public class ResultTypeInterceptor implements Interceptor {
    private static final List<ResultMapping> EMPTY_RESULTMAPPING = new ArrayList<ResultMapping>(0);
    public static final String DEFAULT_KEY = "resultType";
    private String resultType = DEFAULT_KEY;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        final Object[] args = invocation.getArgs();
        MappedStatement ms = (MappedStatement) args[0];
        Object parameterObject = args[1];
        Class resultType = getResultType(parameterObject);
        if (resultType == null) {
            return invocation.proceed();
        }
        args[0] = newMappedStatement(ms, resultType);
        return invocation.proceed();
    }

    public MappedStatement newMappedStatement(MappedStatement ms, Class resultType) {
        MappedStatement.Builder builder = new MappedStatement.Builder(ms.getConfiguration(), ms.getId() + "_" + getShortName(resultType), ms.getSqlSource(), ms.getSqlCommandType());
        builder.resource(ms.getResource());
        builder.fetchSize(ms.getFetchSize());
        builder.statementType(ms.getStatementType());
        builder.keyGenerator(ms.getKeyGenerator());
        if (ms.getKeyProperties() != null && ms.getKeyProperties().length != 0) {
            StringBuilder keyProperties = new StringBuilder();
            for (String keyProperty : ms.getKeyProperties()) {
                keyProperties.append(keyProperty).append(",");
            }
            keyProperties.delete(keyProperties.length() - 1, keyProperties.length());
            builder.keyProperty(keyProperties.toString());
        }
        builder.timeout(ms.getTimeout());
        builder.parameterMap(ms.getParameterMap());
        //count查询返回值int
        List<ResultMap> resultMaps = new ArrayList<ResultMap>();

        String resultMapId = resultType.getCanonicalName();
        ResultMap resultMap;
        if (ms.getConfiguration().hasResultMap(resultMapId)) {
            resultMap = ms.getConfiguration().getResultMap(resultMapId);
        } else {
            resultMap = new ResultMap.Builder(ms.getConfiguration(), ms.getId(), resultType, EMPTY_RESULTMAPPING).build();
        }

        resultMaps.add(resultMap);
        builder.resultMaps(resultMaps);
        builder.resultSetType(ms.getResultSetType());
        builder.cache(ms.getCache());
        builder.flushCacheRequired(ms.isFlushCacheRequired());
        builder.useCache(ms.isUseCache());
        return builder.build();
    }

    private String getShortName(Class clazz) {
        String className = clazz.getCanonicalName();
        return className.substring(className.lastIndexOf(".") + 1);
    }

    private Class getResultType(Object parameterObject) {
        if (parameterObject == null) {
            return null;
        } else if (parameterObject instanceof Class) {
            return (Class) parameterObject;
        } else if (parameterObject instanceof Map) {
            if (((Map) (parameterObject)).containsKey(resultType)) {
                Object result = ((Map) (parameterObject)).get(resultType);
                return objectToClass(result);
            } else {
                return null;
            }
        } else {
            MetaObject metaObject = SystemMetaObject.forObject(parameterObject);
            Object result = metaObject.getValue(resultType);
            return objectToClass(result);
        }
    }

    private Class objectToClass(Object object) {
        if (object == null) {
            return null;
        } else if (object instanceof Class) {
            return (Class) object;
        } else if (object instanceof String) {
            try {
                return Class.forName((String) object);
            } catch (Exception e) {
                throw new RuntimeException("非法的全限定类名字符串:" + object);
            }
        } else {
            throw new RuntimeException("方法参数类型错误，" + resultType + " 对应的参数类型只能为 Class 类型或者为 类的全限定名称字符串");
        }
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        String resultType = properties.getProperty("resultType");
        if (resultType != null && resultType.length() > 0) {
            this.resultType = resultType;
        }
    }
}
