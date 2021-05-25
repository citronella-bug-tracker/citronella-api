package com.lorenjamison.citronella.api.config

import com.lorenjamison.citronella.api.dao.SprintDao
import com.lorenjamison.citronella.api.service.SprintService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SprintApiConfig {
    @Autowired
    lateinit var databaseConfig: DatabaseConfig

    @Bean
    fun sprintService(): SprintService {
        return SprintService(sprintDao())
    }

    @Bean
    fun sprintDao(): SprintDao {
        return SprintDao(databaseConfig.dslContext())
    }
}