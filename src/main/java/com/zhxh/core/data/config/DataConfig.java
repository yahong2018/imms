package com.zhxh.core.data.config;

import com.github.miemiedev.mybatis.callable.CallableConvertInterceptor;
import com.zhxh.core.data.EntitySqlMetaFactory;
import com.zhxh.core.data.ResultTypeInterceptor;
import com.zhxh.core.data.meta.MySqlMetaCreator;
import com.zhxh.core.utils.Logger;
import com.zhxh.core.utils.PropertyLoader;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Map;

@Configuration
public class DataConfig {
    @Autowired
    private MyDataSource dataSource;

    @Autowired
    private ResultTypeInterceptor resultTypeInterceptor;

    @Autowired
    private CallableConvertInterceptor callableConvertInterceptor;

    @Bean
    CallableConvertInterceptor getCallableConvertInterceptor() {
        return new CallableConvertInterceptor();
    }

    @Bean
    public DataSourceTransactionManager getTransactionManager() {
        return new org.springframework.jdbc.datasource.DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionFactoryBean getSqlSessionFactory() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            String mapperLocation = dataSource.getMapperLocations();
            Resource[] mapperLocations = resolver.getResources(mapperLocation);
            sqlSessionFactoryBean.setMapperLocations(mapperLocations);

            Resource configLocation = resolver.getResource(dataSource.getMyBatisConfigLocation());
            sqlSessionFactoryBean.setConfigLocation(configLocation);
        } catch (Exception e) {
            Logger.info("配置 DataSource的 mapperLocation/configLocation出现问题:" + e.getMessage());
        }

        sqlSessionFactoryBean.setDataSource(dataSource);
        Interceptor[] interceptors = new Interceptor[]{this.resultTypeInterceptor, this.callableConvertInterceptor};
        sqlSessionFactoryBean.setPlugins(interceptors);
        sqlSessionFactoryBean.setTypeAliasesPackage(dataSource.getTypeAliasesPackage());

        return sqlSessionFactoryBean;
    }


    @Bean(name = "sqlSession")
    @Scope("prototype")
    public SqlSessionTemplate getSqlSession(SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception {
        SqlSessionFactory factory = sqlSessionFactoryBean.getObject();
        return new org.mybatis.spring.SqlSessionTemplate(factory, ExecutorType.SIMPLE);
    }

    @Bean(name = "validator")
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean result = new LocalValidatorFactoryBean();
        result.setProviderClass(org.hibernate.validator.HibernateValidator.class);

        return result;
    }

    @Bean
    public EntitySqlMetaFactory getEntitySqlMetaFactory(SqlSessionTemplate sqlSession) {
        EntitySqlMetaFactory result = new EntitySqlMetaFactory();

        MySqlMetaCreator mySqlMetaCreator = new MySqlMetaCreator();
        result.setSqlMetaCreator(mySqlMetaCreator);
        result.setSqlSession(sqlSession);
        String mapperLocation = dataSource.getDataTablePropertyFile();
        Map<String, String> propertyMap = PropertyLoader.getPropertyMap(mapperLocation);
        result.setInitEntry(propertyMap);
        result.init();

        return result;
    }
}
