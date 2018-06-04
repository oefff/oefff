package io.github.oefff.review

import gherkin.AstBuilder
import gherkin.Parser
import gherkin.TokenMatcher
import gherkin.ast.Feature
import gherkin.ast.GherkinDocument
import io.github.oefff.api.Epic
import io.github.oefff.project.readConfig
import io.github.oefff.workspace.WorkspaceLocationConfiguration
import mu.KotlinLogging
import org.apache.commons.io.filefilter.SuffixFileFilter
import org.springframework.stereotype.Service
import java.io.BufferedReader
import java.io.File


const val EXTENTION = ".feature"

@Service
class FeatureService(private val workspaceLocationConfiguration: WorkspaceLocationConfiguration = WorkspaceLocationConfiguration()) {
    val parser = Parser(AstBuilder())
    val matcher = TokenMatcher()

    private val workspaceLocation = workspaceLocationConfiguration.workspaceLocation
    private val featureSuffix = ".feature"


    private val logger = KotlinLogging.logger {  }


    fun read(projectName: String, epicName: String, featureName: String): Feature {
        return readFeature(projectName, "$epicName/$featureName")
    }

    fun readFeature(projectName: String, fileReference: String): Feature {

        val path = workspaceLocation + projectName + "/" + readConfig(workspaceLocationConfiguration).specificationPath + fileReference + featureSuffix
        val fis = File(path).inputStream()

        val reader = BufferedReader(fis.bufferedReader())
        val document : GherkinDocument = parser.parse(reader, matcher)

        return document.feature


    }

    fun listEpicsInProject(projectName: String) : List<Epic> {

        val projectDirectory = File(workspaceLocation + projectName)
        return listEpics(projectDirectory)
    }

    fun listEpics(projectDirectory: File): List<Epic> {
        val pathToSpecifications = readConfig(projectDirectory).specificationPath
        return File(projectDirectory.absolutePath + "/" + pathToSpecifications).listFiles()
                .filter { it.isDirectory }
                .map {
                    Epic(it.name, listFeatureNames(it))

                }
    }


    fun listFeatureNames(directory: File): List<String> {
        logger.debug("Going to fetch all featureNames from ${directory.name}")
        return directory.list(SuffixFileFilter(EXTENTION)).asList().map { it.substringBefore(EXTENTION) }
    }

}
