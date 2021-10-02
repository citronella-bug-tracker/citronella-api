//package com.lorenjamison.citronella.api.api.v1
//
//import com.lorenjamison.citronella.api.service.ProjectService
//import groovy.transform.CompileStatic
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.web.bind.annotation.DeleteMapping
//import org.springframework.web.bind.annotation.GetMapping
//import org.springframework.web.bind.annotation.PathVariable
//import org.springframework.web.bind.annotation.PutMapping
//import org.springframework.web.bind.annotation.RequestBody
//import org.springframework.web.bind.annotation.RequestMapping
//import org.springframework.web.bind.annotation.RestController
//
//@CompileStatic
//@RestController
//@RequestMapping(value = ['/api/v1/projects'],
//        produces = ['application/JSON'],
//        consumes = ['application/JSON'])
//class ProjectApi {
//
//    private ProjectService projectService
//
//    @Autowired
//    ProjectApi(ProjectService projectService) {
//        this.projectService = projectService
//    }
//
//    @PutMapping(value = ['/'])
//    Project upsertProject(@RequestBody Project project) {
//        projectService.upsertProject(project)
//    }
//
//    @GetMapping(value = '/{id}')
//    Project getProjectById (@PathVariable Long projectId) {
//        projectService.getProjectById(projectId)
//    }
//
//    @GetMapping(value = '/prefix/{id}')
//    Project getProjectById (@PathVariable String projectPrefix) {
//        projectService.getProjectByPrefix(projectPrefix)
//    }
//
//    @DeleteMapping(value = ['/{id}'])
//    void archiveProject(@PathVariable Long projectId) {
//        projectService.archiveProject(projectId)
//    }
//
//    //TODO: Project search
//}
