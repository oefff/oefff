package io.github.oefff.review

import gherkin.AstBuilder
import gherkin.Parser
import gherkin.TokenMatcher
import gherkin.ast.Feature
import gherkin.ast.GherkinDocument
import io.github.oefff.workspace.FileSystemConfiguration
import io.github.oefff.navigate.Epic
import io.github.oefff.project.readConfig
import org.apache.commons.io.filefilter.SuffixFileFilter
import org.springframework.stereotype.Service
import java.io.BufferedReader
import java.io.File


const val EXTENTION = ".feature"

@Service
class FeatureService(fileSystemConfiguration: FileSystemConfiguration = FileSystemConfiguration()) {
    val parser = Parser(AstBuilder())
    val matcher = TokenMatcher()

    private val basePath = fileSystemConfiguration.getProjectLocation() + readConfig(fileSystemConfiguration).specificationPath
    private val featureSuffix = ".feature"


    fun read(fileReference: String): Feature {

        val path = basePath + fileReference + featureSuffix
        val fis = File(path).inputStream()

        val reader = BufferedReader(fis.bufferedReader())
        val document : GherkinDocument = parser.parse(reader, matcher)

        return document.feature


    }

    fun listEpics() : List<Epic> =
        File(basePath).listFiles()
                .filter { it.isDirectory }
                .map {
                    Epic(it.name, listFeatures(it))

                }


    private fun listFeatures(epicDirectory: File): List<String> {
        return epicDirectory.list(SuffixFileFilter(EXTENTION)).asList().map { it.substringBefore(EXTENTION) }
    }

}
