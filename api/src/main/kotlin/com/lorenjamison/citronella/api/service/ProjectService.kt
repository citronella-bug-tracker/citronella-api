package com.lorenjamison.citronella.api.service

import com.lorenjamison.citronella.api.dao.ProjectDao
import com.lorenjamison.citronella.data.generated.tables.pojos.Project

class ProjectService(private val projectDao: ProjectDao) {

    fun upsertProject(project: Project): Project? {
        if (project.id == null) {
            projectDao.createProject(project)
        } else {
            projectDao.updateProject(project)
        }
        return getProjectByKey(project.projectKey)
    }

    fun getProjectById(id: Int): Project? {
        return projectDao.getProjectById(id)
    }

    fun getProjectByKey(projectKey: String): Project? {
        return projectDao.getProjectByKey(projectKey)
    }

    fun archiveProject(id: Int) {
        projectDao.archiveProject(id)
    }

}
