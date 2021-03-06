package com.zhxh.sys.config;

import com.github.miemiedev.mybatis.callable.CallableConvertInterceptor;
import com.zhxh.core.data.*;
import com.zhxh.core.data.meta.MySqlMetaCreator;
import com.zhxh.core.utils.Logger;
import com.zhxh.imms.material.entity.BomOrder;
import com.zhxh.imms.material.entity.Material;
import com.zhxh.imms.material.vo.BomVO;
import com.zhxh.imms.material.vo.MaterialVO;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ResultMap;
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

@Configuration
public class DataConfig {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private ResultTypeInterceptor resultTypeInterceptor;

    @Autowired
    private UpdateInterceptor updateInterceptor;

    @Autowired
    private CallableConvertInterceptor callableConvertInterceptor;

    @Bean
    public DataSource createDataSource(){
        return new DataSource();
    }

    @Bean
    public ResultTypeInterceptor createResultTypeInterceptor(){
        return new ResultTypeInterceptor();
    }

    @Bean
    public UpdateInterceptor createUpdateInterceptor(){return new UpdateInterceptor();}

    @Bean
    public CallableConvertInterceptor createCallableConvertInterceptor() {
        return new CallableConvertInterceptor();
    }

    @Bean
    public DataSourceTransactionManager createTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionFactoryBean createSqlSessionFactory() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            String mapperLocation = dataSource.getMyBatisMapperFileLocations();
            Resource[] mapperLocations = resolver.getResources(mapperLocation);
            sqlSessionFactoryBean.setMapperLocations(mapperLocations);

            Resource configLocation = resolver.getResource(dataSource.getMyBatisConfigLocation());
            sqlSessionFactoryBean.setConfigLocation(configLocation);
        } catch (Exception e) {
            Logger.info("配置 DataSource的 mapperLocation/configLocation出现问题:" + e.getMessage());
        }

        sqlSessionFactoryBean.setDataSource(dataSource);
        Interceptor[] interceptors = new Interceptor[]{this.resultTypeInterceptor, this.callableConvertInterceptor,this.updateInterceptor};
        sqlSessionFactoryBean.setPlugins(interceptors);
        sqlSessionFactoryBean.setTypeAliasesPackage(dataSource.getMyBatisTypeAliasesPackage());

        return sqlSessionFactoryBean;
    }


    @Bean(name = "sqlSession")
    @Scope("prototype")
    public SqlSessionTemplate createSqlSession(SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception {
        SqlSessionFactory factory = sqlSessionFactoryBean.getObject();
        return new SqlSessionTemplate(factory, ExecutorType.SIMPLE);
    }

    @Bean(name = "validator")
    public LocalValidatorFactoryBean createValidator() {
        LocalValidatorFactoryBean result = new LocalValidatorFactoryBean();
        result.setProviderClass(org.hibernate.validator.HibernateValidator.class);

        return result;
    }

//    @Bean(name="sqlMetaCreator")
//    SqlMetaCreator createSqlMetaCreator(){
//        return new MySqlMetaCreator();
//    }

    @Bean("entitySqlMetaFactory")
    public EntitySqlMetaFactory createEntitySqlMetaFactory(SqlSessionTemplate sqlSession) {
        EntitySqlMetaFactory result = new EntitySqlMetaFactory();
        result.setSqlSession(sqlSession);
        result.setSqlMetaCreator(new MySqlMetaCreator());
        result.init();
//        this.setCustomSelectSql(result,MaterialVO.class,"com.zhxh.imms.material.dao.SQL_GET_MATERIAL_VO");
//        this.setCustomSelectSql(result,MaterialMediaVO.class,sqlSession,"com.zhxh.imms.material.dao.SQL_GET_MATERIAL_MEDIA_VO");
//        this.setCustomSelectSql(result,BomVO.class,"com.zhxh.imms.material.dao.SQL_GET_BOM_VO");
        return result;
    }

    private void setCustomSelectSql(EntitySqlMetaFactory factory, Class clazz, String sqlId){
        EntitySqlMeta meta = factory.getEntitySqlMeta(clazz);
        MappedStatement statement = factory.getSqlSession().getConfiguration().getMappedStatement(sqlId);
        String sql = statement.getSqlSource().getBoundSql(null).getSql();
        meta.setSqlSelect(sql);
        meta.setResultMap(statement.getResultMaps().get(0));
    }
}
