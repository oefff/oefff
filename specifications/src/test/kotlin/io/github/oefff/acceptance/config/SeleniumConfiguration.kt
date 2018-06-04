package io.github.oefff.acceptance.config


import io.github.bonigarcia.wdm.WebDriverManager.chromedriver

import javax.annotation.PostConstruct
import javax.annotation.PreDestroy

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.RemoteWebDriver
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SeleniumConfiguration {

    @Value("\${selenium.driver.headless:true}")
    private val headless: Boolean? = null
    private var webDriver: RemoteWebDriver? = null

    @PostConstruct
    fun startWebDriver() {
        webDriver = createChromeDriver()
    }

    private fun createChromeDriver(): ChromeDriver {
        chromedriver().setup()

        val options = ChromeOptions()
        if (headless!!) {
            options.addArguments("-headless")
        }

        return ChromeDriver(options)
    }

    @PreDestroy
    fun stopWebDriver() {
        webDriver!!.quit()
    }


    @Bean
    fun webDriver(): RemoteWebDriver? {
        return webDriver
    }
}
