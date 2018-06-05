package io.github.oefff.acceptance.steps.api

import com.natpryce.hamkrest.anyElement
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import com.natpryce.hamkrest.has
import cucumber.api.java8.En
import io.github.oefff.api.Project
import org.springframework.core.ParameterizedTypeReference

class ProjectNavigationStep( private val fetcher: OefffFetcher) : En {
    private val listOfProjectsResponseType: ParameterizedTypeReference<List<Project>> = object : ParameterizedTypeReference<List<Project>>() {}


    var url = ""

    init {

        Given("the project 'oefff' is present in the configured workspace") {
            println("Warning: Still depends on already chechout project")
        }

        When("Marco opens Oefff to edit the specifications") {
            url = "/api/projects"
        }

        Then("Marco should be able to select of project '(.*)'") { projectName : String ->



            val projects : List<Project> = fetcher.fetch(url, listOfProjectsResponseType)

            assertThat(projects, anyElement(has(Project::name, equalTo(projectName))))

        }

    }

}




