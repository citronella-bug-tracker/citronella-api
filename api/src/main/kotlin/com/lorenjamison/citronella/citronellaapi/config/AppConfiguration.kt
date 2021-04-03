package com.lorenjamison.citronella.citronellaapi.config

import com.lorenjamison.citronella.citronellaapi.exception.ExceptionTranslator
import org.apache.commons.dbcp2.BasicDataSource
import org.jooq.SQLDialect
import org.jooq.impl.DataSourceConnectionProvider
import org.jooq.impl.DefaultConfiguration
import org.jooq.impl.DefaultDSLContext
import org.jooq.impl.DefaultExecuteListenerProvider
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy

@Configuration
class AppConfiguration (
    @Value("database.url") val dbUrl : String,
    @Value("database.username") val dbUsername : String,
    @Value("database.password") val dbPassword : String,
    @Value("database.driver") val dbDriver : String) {

    @Bean
    fun dataSource() : BasicDataSource {
        val dataSource = BasicDataSource()
        dataSource.url = dbUrl
        dataSource.username = dbUsername
        dataSource.password = dbPassword
        dataSource.driverClassName = dbDriver
        return dataSource
    }

    @Bean
    fun transactionManager() : DataSourceTransactionManager {
        val transactionManager = DataSourceTransactionManager()
        transactionManager.dataSource = dataSource()
        return transactionManager
    }

    @Bean
    fun transactionAwareDataSource(): TransactionAwareDataSourceProxy {
        return TransactionAwareDataSourceProxy(dataSource())
    }

    @Bean
    fun connectionProvider(): DataSourceConnectionProvider {
        return DataSourceConnectionProvider(transactionAwareDataSource())
    }

    @Bean
    fun exceptionTranslator(): ExceptionTranslator {
        return ExceptionTranslator()
    }

    @Bean
    fun config(): DefaultConfiguration {
        val config = DefaultConfiguration()
        config.setSQLDialect(SQLDialect.MARIADB)
        config.setConnectionProvider(connectionProvider())
        config.setExecuteListenerProvider(DefaultExecuteListenerProvider(exceptionTranslator()))
        return config
    }
    @Bean
    fun dslContext(): DefaultDSLContext {
        return DefaultDSLContext(config())
    }
}