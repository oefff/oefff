package io.github.oefff.acceptance.step

import cucumber.api.PendingException
import cucumber.api.java8.En

class WriteFeatureFile(private val homepage: Homepage) : En {
    init {
        Given("^the displayFeature has been written and is part of the existing project$") {
            println("The GIVEN")
            homepage.get()
        }

        When("^Marco selects that feature for review$") {
            // Write code here that turns the phrase above into concrete actions
            throw PendingException()
        }

        Then("^the displayFeature should be displayed$") {
            // Write code here that turns the phrase above into concrete actions
            throw PendingException()
        }

    }
}
