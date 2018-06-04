package io.github.oefff.review

import gherkin.ast.Feature
import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("feature")
class FeatureController(private val featureService: FeatureService) {

    private val logger = KotlinLogging.logger {  }

    @GetMapping("/{epic}/{feature}")
    fun reviewFeature(
            @PathVariable epic: String,
            @PathVariable feature: String): Feature {

        val featureName = "$epic/$feature"
        logger.info("Going to retrieve feature: $featureName")

        return featureService.read("oefff", featureName)
    }
}
