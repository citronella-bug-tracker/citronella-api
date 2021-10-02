package com.lorenjamison.citronella.api.config


import groovy.transform.CompileStatic
import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.SqlSessionFactoryBean
import org.mybatis.spring.annotation.MapperScan
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import javax.sql.DataSource

@Configuration
@CompileStatic
//@MapperScan('com.lorenjamison.citronella.api')
class DatabaseConfig {
    @Value('${database.url}')
    String dbUrl

    @Value('${database.username}')
    String dbUsername

    @Value('${database.password}')
    String dbPassword

    @Bean
    DataSource dataSource() {
        DataSourceBuilder.create()
                .driverClassName('org.mariadb.jdbc.Driver')
                .url(dbUrl)
                .username(dbUsername)
                .password(dbPassword)
                .build()
    }

    @Bean
    SqlSessionFactory sqlSessionFactory() {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean()
        factoryBean.dataSource = dataSource()
        factoryBean.object
    }

}
