package io.github.oefff.acceptance.steps.api

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import cucumber.api.java8.En
import io.github.oefff.acceptance.steps.gui.Homepage
import io.github.oefff.api.Feature
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.client.RestTemplate
import java.net.URI

class ReadFeatureFile(
        @Value("\${test.server.port}") val port: String,
        private val homepage: Homepage,
        private val restTemplate: RestTemplate) : En {


    private val logger = KotlinLogging.logger {  }

    var url = ""

    init {
        Given("^the displayFeature has been written and is part of the existing project$") {
            homepage.get()
        }

        When("^Marco selects the '(.*)' feature for review$") { name : String ->

            when(name) {
                "displayFeature" -> url = "/api/projects/oefff/epics/review/features/$name"
                "configureProject" -> url = "/api/projects/oefff/epics/configuration/features/$name"
            }

        }

        Then("^the feature should be displayed and have the name: (.*)$") { name : String ->

            logger.info("Doing the THEN")


            val url = "http://localhost:${port}${url}"
            val feature = restTemplate.getForObject(URI(url), Feature::class.java)

            assertThat(feature?.name, equalTo(name))


        }


    }
}
