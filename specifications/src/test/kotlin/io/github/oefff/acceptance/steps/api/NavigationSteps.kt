package io.github.oefff.acceptance.steps.api

import com.natpryce.hamkrest.allElements
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.isIn
import cucumber.api.DataTable
import cucumber.api.java8.En
import io.github.oefff.navigate.Epic
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.web.client.RestTemplate

class NavigationSteps(@Value("\${test.server.port}") val port: String,
                      private val restTemplate: RestTemplate) : En {

    var url = ""

    init {
        When("Marco looks at the epic overview") {
            url = "/api/epic"
        }

        Then("^he should be able to see:$") { expectedEpics: DataTable ->

            val expectedEpicNames = expectedEpics.asList(String::class.java)

            val uri = "http://localhost:${port}${url}"
            val epics = restTemplate.exchange(uri,
                    HttpMethod.GET, null, object : ParameterizedTypeReference<List<Epic>>() {

            }).body

            val epicNames = epics!!.map { it.name }

            assertThat(expectedEpicNames, allElements(arePresentIn(epicNames)))
        }
    }


}

inline fun <T> arePresentIn(it: Iterable<T>) = isIn(it)
