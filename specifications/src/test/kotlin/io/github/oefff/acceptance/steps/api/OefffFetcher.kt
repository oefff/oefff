package io.github.oefff.acceptance.steps.api

import org.springframework.beans.factory.annotation.Value
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod.GET
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class OefffFetcher(
        @Value("\${test.server.port}") val port: String,
        private val restTemplate: RestTemplate) {


    fun <T> fetch(url: String, responseType: ParameterizedTypeReference<T>): T {
        val uri = "http://localhost:$port$url"
        return restTemplate.exchange(uri, GET, null, responseType).body!!
    }

}
