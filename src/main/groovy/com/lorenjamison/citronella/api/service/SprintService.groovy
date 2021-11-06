//package com.lorenjamison.citronella.api.service
//
//import com.lorenjamison.citronella.api.dao.SprintDao
//import com.lorenjamison.citronella.data.generated.tables.pojos.Sprint
//import groovy.transform.CompileStatic
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.stereotype.Service
//
//@Service
//@CompileStatic
//class SprintService {
//
//    private SprintDao sprintDao
//
//    @Autowired
//    SprintService(SprintDao sprintDao) {
//        this.sprintDao = sprintDao
//    }
//
//    Sprint upsertSprint(Sprint sprint) {
//        Long sprintId
//        if (sprint.id == null) {
//            sprintId = sprintDao.createSprint(sprint)
//        } else {
//            sprintId = sprint.id
//            sprintDao.updateSprint(sprint)
//        }
//
//        getSprintById(sprintId)
//    }
//
//    Sprint getSprintById(Long sprintId) {
//        sprintDao.getSprintById(sprintId)
//    }
//
//    void startSprint(Long sprintId) {
//
//    }
//
//    void finishSprint(Long sprintId) {
//
//    }
//
//}
