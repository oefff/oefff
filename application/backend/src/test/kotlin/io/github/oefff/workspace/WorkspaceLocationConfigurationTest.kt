package io.github.oefff.workspace

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.endsWith
import com.natpryce.hamkrest.equalTo
import org.junit.Rule
import org.junit.Test
import org.junit.contrib.java.lang.system.RestoreSystemProperties
import org.junit.rules.TestRule


class WorkspaceLocationConfigurationTest {


    @Rule @JvmField
    val restoreSystemProperties: TestRule = RestoreSystemProperties()


    @Test
    fun `it should use a project location specified as System Property`() {

        System.setProperty(WORKSPACE_ARGUMENT_NAME, "/tmp")

        val fileSystemConfiguration = WorkspaceLocationConfiguration()

        assertThat(fileSystemConfiguration.workspaceLocation, equalTo("/tmp"))

    }


    @Test
    fun `it should use a new directory in a tempDirectory`() {


        val fileSystemConfiguration = WorkspaceLocationConfiguration()

        assertThat(fileSystemConfiguration.workspaceLocation, endsWith(".workspace"))

    }
    @Test
    fun `it should support override to use local project for testing purposes`() {


        val fileSystemConfiguration = WorkspaceLocationConfiguration(true)

        assertThat(fileSystemConfiguration.workspaceLocation, equalTo(LOCAL_WORKSPACE_LOCATION))

    }

}
