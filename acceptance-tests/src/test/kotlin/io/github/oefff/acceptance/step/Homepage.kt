package io.github.oefff.acceptance.step

import io.github.oefff.acceptance.webdriver.AbstractWebdriverStep
import org.openqa.selenium.remote.RemoteWebDriver
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class Homepage(@Value("\${test.server.port}") val port: String, webDriver: RemoteWebDriver) : AbstractWebdriverStep(webDriver) {


    fun get() {
        println(port)
        webDriver.get("http://localhost:${port}/")

        println(webDriver.title)
    }

}
