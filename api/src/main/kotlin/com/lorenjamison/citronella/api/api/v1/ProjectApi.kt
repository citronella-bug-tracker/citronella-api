package com.lorenjamison.citronella.api.api.v1

import com.lorenjamison.citronella.api.service.ProjectService
import com.lorenjamison.citronella.data.generated.citronella.tables.pojos.Projects
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/api/v1/projects"])
class ProjectApi(@Autowired val projectService: ProjectService) {

    @PutMapping(value = ["/"],
        consumes = ["application/JSON"],
        produces = ["application/JSON"])
    fun upsertProject(@RequestBody project: Projects): Projects? {
        return projectService.upsertProject(project)
    }

    @GetMapping(value = ["/{id}"],
        produces = ["application/JSON"])
    fun getProjectById(@PathVariable id: String): Projects? {
        return projectService.getProjectById(id)
    }

    @DeleteMapping(value = ["/{id}/delete"])
    fun deleteProject(@PathVariable id: String) {
        projectService.deleteProject(id)
    }

    //TODO: implement project search
//    @GetMapping(value = ["/search"],
//        consumes = ["application/JSON"],
//        produces = ["application/JSON"])
//    fun searchProjects(@RequestBody searchCriteria: ProjectSearchCriteriaBean): List<Projects>? {
//        return projectService.searchProjects(searchCriteria)
//    }
}
