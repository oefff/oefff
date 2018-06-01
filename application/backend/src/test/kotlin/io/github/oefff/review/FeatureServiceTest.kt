package io.github.oefff.review

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo

import org.junit.Test
import gherkin.ast.GherkinDocument
import gherkin.TokenMatcher
import gherkin.AstBuilder
import gherkin.Parser
import java.io.BufferedReader
import java.io.File


class FeatureServiceTest {

    private val featureService = FeatureService()


    @Test
    fun buildFeature() {

        val feature = featureService.read("review/displayFeature")
        assert.that(feature.name, equalTo("Display an existing feature"))

    }

}
