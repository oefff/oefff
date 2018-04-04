package io.github.oefff.review

import gherkin.ast.Feature
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FeatureController(private val featureService: FeatureService) {

    @GetMapping("/feature/review/displayFeature")
    fun helloKotlin(): Feature {
        return featureService.read("review/displayFeature")
    }
}
