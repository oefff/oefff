package io.github.oefff.review

import gherkin.ast.Feature
import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("feature")
class FeatureController(private val featureService: FeatureService) {

    private val logger = KotlinLogging.logger {  }

    @GetMapping("/review/displayFeature")
    fun reviewFeature(): Feature {

        val featureName = "review/displayFeature"
        logger.info("Going to retrieve feature: ${featureName}")

        return featureService.read(featureName)
    }
}
