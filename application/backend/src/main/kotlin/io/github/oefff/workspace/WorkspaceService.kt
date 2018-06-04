package io.github.oefff.workspace

import io.github.oefff.api.Project
import org.springframework.stereotype.Service
import java.io.FileFilter

@Service
class WorkspaceService(private val workspaceLocationConfiguration: WorkspaceLocationConfiguration) {

    val directoryFilter : FileFilter by lazy {
        FileFilter {
            it.isDirectory
        }
    }


    fun listProjects(): List<Project> =
        workspaceLocationConfiguration.getWorkspace()
                .listFiles(directoryFilter)
                .map { Project(it.name) }



}
