package com.lorenjamison.citronella.citronellaapi.api.v1

import com.lorenjamison.citronellaapi.data.generated.citronella.tables.pojos.Projects
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/api/v1/projects"])
class ProjectApi {
    @PutMapping(value = ["/"],
        consumes = ["application/JSON"],
        produces = ["application/JSON"])
    fun upsertProject(@RequestBody project: Projects): Projects? {

    }
}