package io.github.oefff.acceptance.step

import io.github.oefff.acceptance.webdriver.AbstractWebdriverStep
import mu.KotlinLogging
import org.openqa.selenium.remote.RemoteWebDriver
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class Homepage(@Value("\${test.server.port}") val port: String, webDriver: RemoteWebDriver) : AbstractWebdriverStep(webDriver) {


    private val logger = KotlinLogging.logger {  }

    fun get() {
        logger.info("Going to connecto to localhost: ${port}")
        webDriver.get("http://localhost:${port}/feature/review/displayFeature")

        println(webDriver.title)
    }

}
