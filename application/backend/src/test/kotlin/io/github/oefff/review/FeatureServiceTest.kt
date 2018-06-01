package io.github.oefff.review

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import org.junit.Test


class FeatureServiceTest {

    private val featureService = FeatureService()


    @Test
    fun buildFeature() {

        val feature = featureService.read("review/displayFeature")
        assert.that(feature.name, equalTo("Display an existing feature"))

    }

}
