package com.lorenjamison.citronella.api.config

import com.lorenjamison.citronella.api.dao.ProjectDao
import com.lorenjamison.citronella.api.service.ProjectService
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