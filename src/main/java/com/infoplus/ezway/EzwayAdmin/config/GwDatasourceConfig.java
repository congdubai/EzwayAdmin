package com.infoplus.ezway.EzwayAdmin.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.infoplus.ezway.EzwayAdmin.mapper", sqlSessionFactoryRef = "ekycGwSqlSessionFactory")
public class GwDatasourceConfig {
    @Value("${spring.datasource.ezwayadmin.hikari.minimum-idle}")
    private int minimumIdle;
    @Value("${spring.datasource.ezwayadmin.hikari.maximum-pool-size}")
    private int maximumPoolSize;
    @Value("${spring.datasource.ezwayadmin.hikari.connection-timeout}")
    private int connectionTimeout;

    @Bean(name = "ekycGwDataSourceProperties")
    @ConfigurationProperties("spring.datasource.ezwayadmin")
    public DataSourceProperties idCheckDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "ekycGwDataSource")
    public DataSource idCheckDataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDataSource(idCheckDataSourceProperties().initializeDataSourceBuilder().build());
        hikariDataSource.setMinimumIdle(minimumIdle);
        hikariDataSource.setMaximumPoolSize(maximumPoolSize);
        hikariDataSource.setConnectionTimeout(connectionTimeout);
        return hikariDataSource;
    }

    @Bean(name = "ekycGwSqlSessionFactory")
    public SqlSessionFactory idCheckSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(idCheckDataSource());
        sessionFactory.setConfigLocation(new ClassPathResource("mybatis/mybatis-config.xml"));
        sessionFactory.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/*.xml")
        );
        return sessionFactory.getObject();
    }

    @Bean(name = "ekycGwTransactionManager")
    @Primary
    public PlatformTransactionManager idCheckTransactionManager() {
        return new DataSourceTransactionManager(idCheckDataSource());
    }

    @Bean("ekycGwJdbcTemplate")
    public JdbcTemplate jdbcTemplate(@Qualifier("ekycGwDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
