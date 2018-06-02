package io.github.oefff.workspace

import org.springframework.stereotype.Component
import java.io.File

const val PROJECT_LOCATION =  "/Users/mabe/projects/com/github/oefff/oefff/"

@Component
class FileSystemConfiguration(private val useLocalProject : Boolean = false) {

    fun getProjectLocation() : String {

        val projectLocationProperty = System.getProperty("OEFFF_PROJECT_LOCATION")
        if (projectLocationProperty != null) {
            return projectLocationProperty
        }

        if (useLocalProject) {
            return PROJECT_LOCATION
        }

        val createTempDir = createTempDir("oefff", ".projects")
        return createTempDir.absolutePath

    }

    fun getProjectDirectory() : File {
        return File(getProjectLocation())
    }

}
