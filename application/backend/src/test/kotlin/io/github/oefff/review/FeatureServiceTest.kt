package io.github.oefff.review

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import com.natpryce.hamkrest.hasElement
import io.github.oefff.workspace.WorkspaceLocationConfiguration
import org.junit.Test


class FeatureServiceTest {

    private val featureService = FeatureService(WorkspaceLocationConfiguration(useLocalProject = true))


    @Test
    fun buildFeature() {

        val feature = featureService.read("oefff", "review", "displayFeature")
        assert.that(feature.name, equalTo("Display an existing feature"))

    }

    @Test
    fun `it should list all epics`() {
        val epics = featureService.listEpicsInProject("oefff")

        val configurationEpic = epics.filter { it.name == "configuration" }
        assertThat(configurationEpic[0].features, hasElement("configureProject"))

    }
}
