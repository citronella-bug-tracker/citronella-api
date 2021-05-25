package com.lorenjamison.citronella.api.dao

import com.lorenjamison.citronella.data.generated.tables.Project.*
import com.lorenjamison.citronella.data.generated.tables.pojos.Project
import com.lorenjamison.citronella.data.generated.tables.records.ProjectRecord
import org.jooq.DSLContext

const val ARCHIVED: Byte = 1

class ProjectDao(private val dslContext: DSLContext) {

    fun getProjectById(id: Long): Project? {
        return dslContext.fetchOne(PROJECT, PROJECT.ID.eq(id))?.into(Project::class.java)
    }

    fun getProjectByPrefix(prefix: String): Project? {
        return dslContext.fetchOne(PROJECT, PROJECT.ISSUE_PREFIX.eq(prefix))?.into(Project::class.java)
    }

    fun createProject(project: Project): Long {
        val projectRecord: ProjectRecord = dslContext.newRecord(PROJECT, project)
        projectRecord.store()
        return dslContext.lastID().toLong()
    }

    fun updateProject(project: Project) {
        val projectRecord: ProjectRecord = dslContext.newRecord(PROJECT, project)
        dslContext.executeUpdate(projectRecord)
    }

    fun archiveProject(projectId: Long) {
        dslContext.update(PROJECT)
            .set(PROJECT.ARCHIVED, ARCHIVED)
            .where(PROJECT.ID.eq(projectId))
            .execute()
    }

}
