package io.github.oefff.project

import com.google.gson.Gson
import io.github.oefff.workspace.WorkspaceLocationConfiguration
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

const val NAME_OF_CONFIGURATION_FILE = "oefff.json"

data class Configuration(val specificationPath : String)


fun readConfig(projectBaseDir: File) : Configuration {
    val file = File(projectBaseDir, NAME_OF_CONFIGURATION_FILE)
    if (file.exists()) {
        return Gson().fromJson(BufferedReader(FileReader(file)), Configuration::class.java)
    }
    return DefaultConfigurationBuilder().build()

}

fun readConfig(workspaceLocationConfiguration: WorkspaceLocationConfiguration) : Configuration {
    return readConfig(workspaceLocationConfiguration.getWorkspace())
}

