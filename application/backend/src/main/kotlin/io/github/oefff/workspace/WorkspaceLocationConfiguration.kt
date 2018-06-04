package io.github.oefff.workspace

import mu.KotlinLogging
import org.springframework.stereotype.Component
import java.io.File


const val WORKSPACE_ARGUMENT_NAME = "OEFFF_WORKSPACE_LOCATION"
const val LOCAL_WORKSPACE_LOCATION =  "/Users/mabe/projects/com/github/oefff/oefff/"

class WorkspaceLocationConfiguration(private val useLocalProject : Boolean = false) {

    private val logger = KotlinLogging.logger {  }

    val workspaceLocation : String by lazy {
        determineWorkspaceLocation()
    }

    private fun determineWorkspaceLocation() : String {

        val configuredWorkspaceLocation = System.getProperty(WORKSPACE_ARGUMENT_NAME)
        return configuredWorkspaceLocation ?: findDefaultLocation()

    }

    private fun findDefaultLocation(): String {
        if (useLocalProject) {
            return LOCAL_WORKSPACE_LOCATION
        }

        val createTempDir = createTempDir("oefff", ".workspace")
        return createTempDir.absolutePath
    }

    fun getWorkspace() : File {
        return File(workspaceLocation)
    }

}
