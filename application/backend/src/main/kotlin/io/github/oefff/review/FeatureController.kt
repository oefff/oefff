package io.github.oefff.review

import gherkin.ast.Feature
import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("projects")
class FeatureController(private val featureService: FeatureService) {

    private val logger = KotlinLogging.logger {  }

    @GetMapping("/{projectName}/epics/{epicName}/features/{feature}")
    fun reviewFeature(
            @PathVariable projectName: String,
            @PathVariable epicName: String,
            @PathVariable featureName: String): Feature {

        logger.info("Going to retrieve feature: $epicName/$featureName")

        return featureService.read("oefff", epicName, featureName)
    }
}
