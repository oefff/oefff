package io.github.oefff.acceptance.step

import cucumber.api.java8.En
import mu.KotlinLogging

class GitRepositoryStep : En {

    private val logger = KotlinLogging.logger {  }

    init {

        Given("the Online Editor For Feature File is configured to edit itself") {
            logger.warn("Still need to implement something to checkout a project from origin into System.temp")
        }

    }
}
