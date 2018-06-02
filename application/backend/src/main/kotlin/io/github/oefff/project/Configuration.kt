package io.github.oefff.project

import com.google.gson.Gson
import io.github.oefff.workspace.FileSystemConfiguration
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

const val NAME_OF_CONFIGURATION_FILE = "oefff.json"

data class Configuration(val specificationPath : String)


fun readConfig(projectBaseDir: File) : Configuration {
    return Gson().fromJson(BufferedReader(FileReader(File(projectBaseDir, NAME_OF_CONFIGURATION_FILE))), Configuration::class.java)
}

fun readConfig(fileSystemConfiguration: FileSystemConfiguration) : Configuration {
    return readConfig(fileSystemConfiguration.getProjectDirectory())
}

