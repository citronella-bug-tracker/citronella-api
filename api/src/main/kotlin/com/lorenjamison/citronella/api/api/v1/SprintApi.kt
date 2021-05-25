package com.lorenjamison.citronella.api.api.v1

import com.lorenjamison.citronella.api.service.SprintService
import com.lorenjamison.citronella.data.generated.tables.pojos.Sprint
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/api/v1/sprints"])
class SprintApi(@Autowired val sprintService: SprintService) {

    @PutMapping(value = ["/"],
        consumes = ["application/JSON"],
        produces = ["application/JSON"])
    fun upsertSprint(@RequestBody sprint: Sprint): Sprint? {
        return sprintService.upsertSprint(sprint)
    }

    @GetMapping(value = ["/{id}"],
        produces = ["application/JSON"])
    fun getSprintById(@PathVariable id: Long): Sprint? {
        return sprintService.getSprintById(id)
    }

    @PostMapping(value = ["/{id}/start"])
    fun startSprint(@PathVariable id: Long) {
        sprintService.startSprint(id)
    }

    @PostMapping(value = ["/{id}/finish"])
    fun endSprint(@PathVariable id: Long) {
        sprintService.finishSprint(id)
    }

    //TODO: implement sprint search
}
