package io.github.oefff.review

import com.natpryce.hamkrest.anyElement
import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import com.natpryce.hamkrest.has
import io.github.oefff.api.Epic
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

        assertThat(epics, anyElement(has(Epic::name, equalTo("configuration"))))
        assertThat(epics, anyElement(has(Epic::name, equalTo("navigate"))))


    }
}
