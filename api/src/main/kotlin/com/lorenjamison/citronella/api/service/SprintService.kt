package com.lorenjamison.citronella.api.service

import com.lorenjamison.citronella.api.dao.SprintDao
import com.lorenjamison.citronella.data.generated.tables.pojos.Sprint

class SprintService(private val sprintDao: SprintDao) {

    fun upsertSprint(sprint: Sprint): Sprint? {
        val returnSprintId: Long
        if (sprint.id == null) {
            returnSprintId = sprintDao.createSprint(sprint)
        } else {
            returnSprintId = sprint.id
            sprintDao.updateSprint(sprint)
        }
        return getSprintById(returnSprintId)
    }

    fun getSprintById(id: Long): Sprint? {
        return sprintDao.getSprintById(id)
    }

    fun startSprint(id: Long) {

    }

    fun finishSprint(id: Long) {

    }

}
