package io.github.oefff.feature

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo

import org.junit.Test
import gherkin.ast.GherkinDocument
import gherkin.TokenMatcher
import gherkin.AstBuilder
import gherkin.Parser
import java.io.BufferedReader
import java.io.File


class FeatureTest {

    private val path = "/Users/mabe/projects/com/github/oefff/oefff/documentation/features/displayFeature.feature";
    private val fis = File(path).inputStream()

    private val reader = BufferedReader(fis.bufferedReader())

    @Test
    fun buildFeature() {

        val parser = Parser(AstBuilder())
        val matcher = TokenMatcher()


        var document : GherkinDocument = parser.parse(reader, matcher)

        assert.that(document.feature.name, equalTo("Display an existing feature"))
        println(document.feature.name)
    }

}
