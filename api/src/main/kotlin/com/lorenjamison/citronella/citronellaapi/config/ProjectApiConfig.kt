package com.lorenjamison.citronella.citronellaapi.config

import com.lorenjamison.citronella.citronellaapi.dao.ProjectDao
import com.lorenjamison.citronella.citronellaapi.service.ProjectService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean

class ProjectApiConfig {
    @Autowired
    lateinit var databaseConfig: DatabaseConfig

    @Bean
    fun projectService(): ProjectService {
        return ProjectService(projectDao())
    }

    @Bean
    fun projectDao(): ProjectDao {
        return ProjectDao(databaseConfig.dslContext())
    }
}