package com.lorenjamison.citronella.citronellaapi.service

import com.lorenjamison.citronella.citronellaapi.dao.ProjectDao
import com.lorenjamison.citronellaapi.data.generated.citronella.tables.pojos.Projects

class ProjectService(private val projectDao: ProjectDao) {

    fun upsertProject(project: Projects): Projects? {

    }

    fun getProjectById(id: String): Projects? {

    }

    fun deleteProject(id: String) {

    }

}
