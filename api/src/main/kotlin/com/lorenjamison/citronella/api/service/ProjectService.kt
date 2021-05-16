package com.lorenjamison.citronella.api.service

import com.lorenjamison.citronella.api.dao.ProjectDao
import com.lorenjamison.citronella.data.generated.citronella.tables.pojos.Projects

class ProjectService(private val projectDao: ProjectDao) {

    fun upsertProject(project: Projects): Projects? {

    }

    fun getProjectById(id: String): Projects? {

    }

    fun deleteProject(id: String) {

    }

}
