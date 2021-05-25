package com.lorenjamison.citronella.api.api.v1

import com.lorenjamison.citronella.api.service.ProjectService
import com.lorenjamison.citronella.data.generated.tables.pojos.Project
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/api/v1/projects"])
class ProjectApi(@Autowired val projectService: ProjectService) {

    @PutMapping(value = ["/"],
        consumes = ["application/JSON"],
        produces = ["application/JSON"])
    fun upsertProject(@RequestBody project: Project): Project? {
        return projectService.upsertProject(project)
    }

    @GetMapping(value = ["/{id}"],
        produces = ["application/JSON"])
    fun getProjectById(@PathVariable id: Long): Project? {
        return projectService.getProjectById(id)
    }

    @GetMapping(value = ["/prefix/{projectKey}"],
        produces = ["application/JSON"])
    fun getProjectByPrefix(@PathVariable prefix: String): Project? {
        return projectService.getProjectByPrefix(prefix)
    }

    @DeleteMapping(value = ["/{id}"])
    fun archiveProject(@PathVariable id: Long) {
        projectService.archiveProject(id)
    }

    //TODO: implement project search
//    @GetMapping(value = ["/search"],
//        consumes = ["application/JSON"],
//        produces = ["application/JSON"])
//    fun searchProjects(@RequestBody searchCriteria: ProjectSearchCriteriaBean): List<Project>? {
//        return projectService.searchProjects(searchCriteria)
//    }
}
