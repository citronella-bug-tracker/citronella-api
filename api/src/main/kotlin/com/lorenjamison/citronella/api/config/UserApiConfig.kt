package com.lorenjamison.citronella.api.config

import com.lorenjamison.citronella.api.dao.UserDao
import com.lorenjamison.citronella.api.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UserApiConfig {

    @Autowired
    lateinit var databaseConfig: DatabaseConfig

    @Bean
    fun userService(): UserService {
        return UserService(userDao())
    }

    @Bean
    fun userDao(): UserDao {
        return UserDao(databaseConfig.dslContext())
    }
}