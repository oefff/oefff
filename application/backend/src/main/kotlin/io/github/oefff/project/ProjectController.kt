package io.github.oefff.project

import io.github.oefff.api.Project
import io.github.oefff.workspace.WorkspaceService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("projects")
class ProjectController(private val workspaceService: WorkspaceService) {

    @GetMapping()
    fun getAll() : List<Project> = workspaceService.listProjects()

    @GetMapping("/{projectName}")
    fun getProject(@PathVariable projectName : String) : Project = workspaceService.readProject(projectName)


}
