//package com.lorenjamison.citronella.api.api.v1
//
//import com.lorenjamison.citronella.api.service.SprintService
//import com.lorenjamison.citronella.data.generated.tables.pojos.Sprint
//import groovy.transform.CompileStatic
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.web.bind.annotation.*
//
//@RestController
//@CompileStatic
//@RequestMapping(value = ['/api/v1/sprints'],
//        produces = ['application/JSON'],
//        consumes = ['application/JSON'])
//class SprintApi {
//
//    private SprintService sprintService
//
//    @Autowired
//    SprintApi(SprintService sprintService) {
//        this.sprintService = sprintService
//    }
//
//    @PutMapping(value = ['/'])
//    Sprint upsertSprint(@RequestBody Sprint sprint) {
//        sprintService.upsertSprint(sprint)
//    }
//
//    @GetMapping(value = ['/{id}'])
//    Sprint getSprintById(@PathVariable Long sprintId) {
//        sprintService.getSprintById(sprintId)
//    }
//
//    @PostMapping(value = ['/{id}/start'])
//    void startSprint(@PathVariable Long sprintId) {
//        sprintService.startSprint(sprintId)
//    }
//
//    @PostMapping(value = ['/{id}/finish'])
//    void finishSprint(@PathVariable Long sprintId) {
//        sprintService.finishSprint(sprintId)
//    }
//
//    //TODO: Sprint search
//}
