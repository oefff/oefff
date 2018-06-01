package io.github.oefff.acceptance.step

import com.natpryce.hamkrest.allElements
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.isIn
import cucumber.api.DataTable
import cucumber.api.java8.En
import io.github.oefff.acceptance.OefffFeature
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.web.client.RestTemplate
import java.net.URI

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
                    HttpMethod.GET, null, object : ParameterizedTypeReference<List<String>>() {

            }).body
            assertThat(epics!!, allElements(isIn(expectedEpicNames)))
        }
    }


}
