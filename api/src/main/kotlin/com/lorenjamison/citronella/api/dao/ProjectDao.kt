package com.lorenjamison.citronella.api.dao

import com.lorenjamison.citronella.data.generated.tables.Project.*
import com.lorenjamison.citronella.data.generated.tables.pojos.Project
import com.lorenjamison.citronella.data.generated.tables.records.ProjectRecord
import org.jooq.DSLContext

const val ARCHIVED: Byte = 1

class ProjectDao(private val dslContext: DSLContext) {

    fun getProjectById(id: Int): Project? {
        return dslContext.fetchOne(PROJECT, PROJECT.ID.eq(id))?.into(Project::class.java)
    }

    fun getProjectByKey(projectKey: String): Project? {
        return dslContext.fetchOne(PROJECT, PROJECT.PROJECT_KEY.eq(projectKey))?.into(Project::class.java)
    }

    fun createProject(project: Project) {
        val projectRecord: ProjectRecord = dslContext.newRecord(PROJECT, project)
        projectRecord.store()
    }

    fun updateProject(project: Project) {
        val projectRecord: ProjectRecord = dslContext.newRecord(PROJECT, project)
        dslContext.executeUpdate(projectRecord)
    }

    fun archiveProject(projectId: Int) {
        dslContext.update(PROJECT)
            .set(PROJECT.ARCHIVED, ARCHIVED)
            .where(PROJECT.ID.eq(projectId))
            .execute()
    }

}
