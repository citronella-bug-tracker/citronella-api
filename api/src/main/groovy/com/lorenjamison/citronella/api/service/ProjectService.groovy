//package com.lorenjamison.citronella.api.service
//
//import com.lorenjamison.citronella.api.dao.ProjectDao
//import com.lorenjamison.citronella.data.generated.tables.pojos.Project
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.stereotype.Service
//
//@Service
//class ProjectService {
//
//    private ProjectDao projectDao
//
//    @Autowired
//    ProjectService(ProjectDao projectDao) {
//        this.projectDao = projectDao
//    }
//
//    Project upsertProject(Project project) {
//        Long projectId
//        if (project.id == null) {
//            projectId = projectDao.createProject(project)
//        } else {
//            projectId = project.id
//            projectDao.updateProject(project)
//        }
//
//        getProjectById(projectId)
//    }
//
//    Project getProjectById(Long projectId) {
//        projectDao.getProjectById(projectId)
//    }
//
//    Project getProjectByPrefix(String prefix) {
//        projectDao.getProjectByPrefix(prefix)
//    }
//
//    void archiveProject(Long projectId) {
//        projectDao.archiveProject(projectId)
//    }
//}
