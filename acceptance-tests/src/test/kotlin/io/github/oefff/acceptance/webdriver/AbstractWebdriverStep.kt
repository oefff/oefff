package io.github.oefff.acceptance.webdriver

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.RemoteWebDriver

abstract class AbstractWebdriverStep protected constructor(protected val webDriver: RemoteWebDriver) {

    protected fun setAttribute(by: By, attribute: String, value: String) {
        val element = webDriver.findElement(by)
        webDriver.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", element, attribute, value)
    }
}
