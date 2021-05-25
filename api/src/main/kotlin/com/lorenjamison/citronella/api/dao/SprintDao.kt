package com.lorenjamison.citronella.api.dao

import com.lorenjamison.citronella.data.generated.tables.Sprint.*
import com.lorenjamison.citronella.data.generated.tables.pojos.Sprint
import com.lorenjamison.citronella.data.generated.tables.records.SprintRecord
import org.jooq.DSLContext

class SprintDao(private val dslContext: DSLContext) {

    fun getSprintById(id: Long): Sprint? {
        return dslContext.fetchOne(SPRINT, SPRINT.ID.eq(id))?.into(Sprint::class.java)
    }

    fun createSprint(sprint: Sprint): Long {
        val sprintRecord: SprintRecord = dslContext.newRecord(SPRINT, sprint)
        sprintRecord.store()
        return dslContext.lastID().toLong()
    }

    fun updateSprint(sprint: Sprint) {
        val sprintRecord: SprintRecord = dslContext.newRecord(SPRINT, sprint)
        dslContext.executeUpdate(sprintRecord)
    }

}
