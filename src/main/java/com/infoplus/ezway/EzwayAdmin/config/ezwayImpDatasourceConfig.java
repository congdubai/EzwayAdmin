package com.infoplus.ezway.EzwayAdmin.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
//@MapperScan(basePackages = "com.infoplus.EzwayAdmin.ws.mapperekycimp", sqlSessionFactoryRef = "ekycImpSqlSessionFactory")
public class ezwayImpDatasourceConfig {
    @Value("${spring.datasource.ezwayadmin.hikari.minimum-idle}")
    private int minimumIdle;
    @Value("${spring.datasource.ezwayadmin.hikari.maximum-pool-size}")
    private int maximumPoolSize;
    @Value("${spring.datasource.ezwayadmin.hikari.connection-timeout}")
    private int connectionTimeout;

    @Bean(name = "ezwayImpDataSourceProperties")
    @ConfigurationProperties("spring.datasource.ezwayadmin")
    public DataSourceProperties idCheckDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "ezwayImpDataSource")
    public DataSource ekycImpDataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDataSource(idCheckDataSourceProperties().initializeDataSourceBuilder().build());
        hikariDataSource.setMinimumIdle(minimumIdle);
        hikariDataSource.setMaximumPoolSize(maximumPoolSize);
        hikariDataSource.setConnectionTimeout(connectionTimeout);
        return hikariDataSource;
    }

    @Bean(name = "ezwayImpSqlSessionFactory")
    public SqlSessionFactory idCheckSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(ekycImpDataSource());
        sessionFactory.setConfigLocation(new ClassPathResource("mybatis/mybatis-config.xml"));
        sessionFactory.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapperekycimp/*.xml")
        );
        return sessionFactory.getObject();
    }

    @Bean(name = "ezwayImpTransactionManager")
    public PlatformTransactionManager idCheckTransactionManager() {
        return new DataSourceTransactionManager(ekycImpDataSource());
    }
}
