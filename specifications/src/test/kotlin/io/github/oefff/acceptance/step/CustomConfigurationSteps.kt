package io.github.oefff.acceptance.step

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.hasElement
import com.natpryce.hamkrest.isA
import cucumber.api.java8.En
import io.github.oefff.project.Configuration
import io.github.oefff.project.readConfig
import io.github.oefff.review.FeatureService
import io.github.oefff.review.PROJECT_LOCATION
import java.io.File

class CustomConfigurationSteps() : En {

    private val readConfig = readConfig(File(PROJECT_LOCATION))

    init {
        Given("^the Oefff git repository has custom configuration") {

            assertThat(readConfig, isA<Configuration>())

        }

        Given("^the project contains feature files underneath the configured specification location$") {
            val epics = FeatureService().listEpics()

            assertThat(epics.map{it.name}, hasElement("configuration"))

        }


    }
}
