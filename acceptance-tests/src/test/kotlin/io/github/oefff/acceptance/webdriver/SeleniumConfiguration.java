package io.github.oefff.acceptance.webdriver;


import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeleniumConfiguration {

    @Value("${selenium.driver.headless:true}")
    private Boolean headless;
    private RemoteWebDriver webDriver;

    @PostConstruct
    public void startWebDriver() {
        webDriver = createChromeDriver();
    }

    private ChromeDriver createChromeDriver() {
        chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        if (headless) {
            options.addArguments("-headless");
        }

        return new ChromeDriver(options);
    }

    @PreDestroy
    public void stopWebDriver() {
        webDriver.quit();
    }


    @Bean
    public RemoteWebDriver webDriver() {
        return webDriver;
    }
}
