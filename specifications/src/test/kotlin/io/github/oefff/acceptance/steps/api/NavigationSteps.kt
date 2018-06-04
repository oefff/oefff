package io.github.oefff.acceptance.steps.api

import com.natpryce.hamkrest.allElements
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.isIn
import cucumber.api.DataTable
import cucumber.api.java8.En
import io.github.oefff.api.Epic
import org.springframework.core.ParameterizedTypeReference

class NavigationSteps(private val fetcher: OefffFetcher) : En {

    var url = ""

    private val listOfEpicResponseType: ParameterizedTypeReference<List<Epic>> = object : ParameterizedTypeReference<List<Epic>>() {}

    init {
        When("Marco looks at the epic overview of '(.*)'") { projectName: String ->
            url = "/api/$projectName/epic"
        }


        Then("^he should be able to see:$") { expectedEpics: DataTable ->

            val expectedEpicNames = asStrings(expectedEpics)

            val epics  = fetcher.fetch(url, listOfEpicResponseType)
            val epicNames = epics.map { it.name }

            assertThat(expectedEpicNames, allElements(arePresentIn(epicNames)))
        }
    }


}

private inline fun <T> arePresentIn(it: Iterable<T>) = isIn(it)
private inline fun asStrings(it: DataTable) : List<String> = it.asList(String::class.java)
