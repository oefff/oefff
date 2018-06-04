package io.github.oefff.workspace

import io.github.oefff.api.Project
import io.github.oefff.review.FeatureService
import org.springframework.stereotype.Service
import java.io.File
import java.io.FileFilter

@Service
class WorkspaceService(
        private val workspaceLocationConfiguration: WorkspaceLocationConfiguration,
        private val featureService: FeatureService) {

    val directoryFilter : FileFilter by lazy {
        FileFilter {
            it.isDirectory
        }
    }


    fun listProjects(): List<Project> =
        workspaceLocationConfiguration.getWorkspace()
                .listFiles(directoryFilter)
                .map { parseProject(it) }

    private fun parseProject(projectDirectory: File) : Project {

        val epics = featureService.listEpics(projectDirectory)
        val features = featureService.listFeatureNames(projectDirectory)

        return Project(name = projectDirectory.name,
                epics = epics,
                featureNames = features)
    }

    fun readProject(projectName: String): Project {
        return listProjects().first { it.name == projectName }
    }


}
