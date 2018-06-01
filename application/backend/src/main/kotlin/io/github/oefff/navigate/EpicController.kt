package io.github.oefff.navigate

import io.github.oefff.review.FeatureService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("epic")
class EpicController(val featureService: FeatureService) {

    @GetMapping()
    fun getAll() : List<String> = featureService.listEpics()

}
