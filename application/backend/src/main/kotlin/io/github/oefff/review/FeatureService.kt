package io.github.oefff.review

import gherkin.AstBuilder
import gherkin.Parser
import gherkin.TokenMatcher
import gherkin.ast.Feature
import gherkin.ast.GherkinDocument
import io.github.oefff.project.readConfig
import org.springframework.stereotype.Service
import java.io.BufferedReader
import java.io.File

const val PROJECT_LOCATION =  "/Users/mabe/projects/com/github/oefff/oefff/"

@Service
class FeatureService {
    val parser = Parser(AstBuilder())
    val matcher = TokenMatcher()

    private val basePath = PROJECT_LOCATION + readConfig(File(PROJECT_LOCATION)).specificationPath
    private val featureSuffix = ".feature"


    fun read(fileReference: String): Feature {

        val path = basePath + fileReference + featureSuffix
        val fis = File(path).inputStream()

        val reader = BufferedReader(fis.bufferedReader())
        val document : GherkinDocument = parser.parse(reader, matcher)

        return document.feature


    }

    fun listEpics() =
        File(basePath).listFiles()
                .filter { it.isDirectory }
                .map { it.name }

}
