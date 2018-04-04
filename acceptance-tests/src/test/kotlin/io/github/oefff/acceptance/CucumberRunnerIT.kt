package io.github.oefff.acceptance

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(
        features = ["src/test/features"],
        plugin = ["html:target/testreport", "json:target/cucumber.json", "junit:target/cucumber-results.xml"],
        tags = ["~@workInProgress", "~@additionalBusinessScenario"],
        strict = true,
        monochrome = true)
class CucumberRunnerIT
