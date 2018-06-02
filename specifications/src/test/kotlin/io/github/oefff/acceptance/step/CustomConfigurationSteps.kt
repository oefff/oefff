package io.github.oefff.acceptance.step

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.hasElement
import com.natpryce.hamkrest.isA
import cucumber.api.java8.En
import io.github.oefff.workspace.FileSystemConfiguration
import io.github.oefff.project.Configuration
import io.github.oefff.project.readConfig
import io.github.oefff.review.FeatureService

class CustomConfigurationSteps(
        private val fileSystemConfiguration: FileSystemConfiguration = FileSystemConfiguration(true)
    ) : En {

    private val readConfig = readConfig(fileSystemConfiguration)

    init {
        Given("^the Oefff git repository has custom configuration") {

            assertThat(readConfig, isA<Configuration>())

        }

        Given("^the project contains feature files underneath the configured specification location$") {
            val epics = FeatureService(fileSystemConfiguration).listEpics()

            assertThat(epics.map { it.name }, hasElement("configuration"))

        }


    }
}
