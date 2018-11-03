package com.zhxh.core.data.config;

import com.zhxh.imms.config.ImmsApplicationConfig;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@AutoConfigureBefore(ImmsApplicationConfig.class)
@ConfigurationProperties(prefix = "datasource")
@PropertySource(value={"classpath:settings/data-source.properties"})
public class MyDataSource extends org.apache.commons.dbcp2.BasicDataSource {
    private String dataTablePropertyFile;
    private String mapperLocations;
    private String typeAliasesPackage;
    private String myBatisConfigLocation;

    public String getDataTablePropertyFile() {
        return dataTablePropertyFile;
    }

    public void setDataTablePropertyFile(String dataTablePropertyFile) {
        this.dataTablePropertyFile = dataTablePropertyFile;
    }

    public String getMyBatisConfigLocation() {
        return myBatisConfigLocation;
    }

    public void setMyBatisConfigLocation(String myBatisConfigLocation) {
        this.myBatisConfigLocation = myBatisConfigLocation;
    }

    public String getTypeAliasesPackage() {
        return typeAliasesPackage;
    }

    public void setTypeAliasesPackage(String typeAliasesPackage) {
        this.typeAliasesPackage = typeAliasesPackage;
    }

    public String getMapperLocations() {
        return mapperLocations;
    }

    public void setMapperLocations(String mapperLocations) {
        this.mapperLocations = mapperLocations;
    }
}
