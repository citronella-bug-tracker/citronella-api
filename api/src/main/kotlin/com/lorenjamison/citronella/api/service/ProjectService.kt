package com.lorenjamison.citronella.api.service

import com.lorenjamison.citronella.api.dao.ProjectDao
import com.lorenjamison.citronella.data.generated.tables.pojos.Project

class ProjectService(private val projectDao: ProjectDao) {

    fun upsertProject(project: Project): Project? {
        val returnProjectId: Long
        if (project.id == null) {
            returnProjectId = projectDao.createProject(project)
        } else {
            returnProjectId = project.id
            projectDao.updateProject(project)
        }
        return getProjectById(returnProjectId)
    }

    fun getProjectById(id: Long): Project? {
        return projectDao.getProjectById(id)
    }

    fun getProjectByPrefix(prefix: String): Project? {
        return projectDao.getProjectByPrefix(prefix)
    }

    fun archiveProject(id: Long) {
        projectDao.archiveProject(id)
    }

}
