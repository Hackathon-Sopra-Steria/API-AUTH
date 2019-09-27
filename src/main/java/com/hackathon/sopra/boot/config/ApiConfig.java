package com.hackathon.sopra.boot.config;

import com.hackathon.sopra.boot.properties.Properties;
import com.hackathon.sopra.dao.mapper.UserMapper;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class ApiConfig {

    //properties
    @Bean
    public Properties properties(){
        return new Properties();
    }

    //database
    @Bean
    @ConditionalOnProperty(name="db.enabled")
    public BasicDataSource driverManagerDataSource(final Properties properties){
        BasicDataSource connectionPool = new BasicDataSource();
        connectionPool.setDriverClassName(properties.getDbDriver());
        connectionPool.setUrl(properties.getDbUrl());
        connectionPool.setUsername(properties.getDbUsername());
        connectionPool.setPassword(properties.getDbPassword());
        return connectionPool;

    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(final BasicDataSource driverManagerDataSource) {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setConfigLocation(new ClassPathResource("static/config.xml"));
        sqlSessionFactory.setDataSource(driverManagerDataSource);
        return sqlSessionFactory;
    }

    @Bean
    public MapperFactoryBean<UserMapper> userMapper(final SqlSessionFactory sqlSessionFactory1){
        final MapperFactoryBean<UserMapper> mfb = new MapperFactoryBean<>();
        mfb.setMapperInterface(UserMapper.class);
        mfb.setSqlSessionFactory(sqlSessionFactory1);
        return mfb;
    }
}
