package com.kashuo.kap.bill.configure;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.PreDestroy;

/**
 *
 * 1. 配置类， @Configuration
 * 2. @MapperScan(basePackages = { "com.kashuo.kap.bill" }) 必须加，否则，找不到对应的mapper
 * 3. @EnableConfigurationProperties(ConnectSettings.class) 获取信息。
 *
 * Created by sunjiawei on 2017/4/18.
 */
@Configuration
@EnableConfigurationProperties(ConnectSettings.class)
@MapperScan(basePackages = { "com.kashuo.kap.bill" })
public class MyBatisConfig {
    @Autowired
    private ConnectSettings dataSourceProperties;

    private DataSource dataSource;

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        ConnectSettings config = this.dataSourceProperties;

        this.dataSource = new DataSource();

        this.dataSource.setDriverClassName(config.getDriverClass());
        this.dataSource.setUrl(config.getUrl());
        if (config.getUsername() != null) {
            this.dataSource.setUsername(config.getUsername());
        }
        if (config.getPassword() != null) {
            this.dataSource.setPassword(config.getPassword());
        }
        return this.dataSource;
    }

    @PreDestroy
    public void close() {
        if (this.dataSource != null)
            this.dataSource.close();
    }

    @Bean
    @Lazy
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:com/kashuo/kap/bill/dao/mapper/*Mapper.xml"));
//        sqlSessionFactoryBean.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"));//分页，将在配置类中处理
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    @Lazy
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
