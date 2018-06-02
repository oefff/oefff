package io.github.oefff.workspace

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.endsWith
import com.natpryce.hamkrest.equalTo
import io.github.oefff.workspace.FileSystemConfiguration
import io.github.oefff.workspace.PROJECT_LOCATION
import org.junit.Rule
import org.junit.Test
import org.junit.contrib.java.lang.system.RestoreSystemProperties
import org.junit.rules.TestRule


class FileSystemConfigurationTest {


    @Rule @JvmField
    val restoreSystemProperties: TestRule = RestoreSystemProperties()


    @Test
    fun `it should use a project location specified as System Property`() {

        System.setProperty("OEFFF_PROJECT_LOCATION", "/tmp")

        val fileSystemConfiguration = FileSystemConfiguration()

        assertThat(fileSystemConfiguration.getProjectLocation(), equalTo("/tmp"))

    }


    @Test
    fun `it should use a new directory in a tempDirectory`() {


        val fileSystemConfiguration = FileSystemConfiguration()

        assertThat(fileSystemConfiguration.getProjectLocation(), endsWith(".projects"))

    }
    @Test
    fun `it should support override to use local project for testing purposes`() {


        val fileSystemConfiguration = FileSystemConfiguration(true)

        assertThat(fileSystemConfiguration.getProjectLocation(), equalTo(PROJECT_LOCATION))

    }

}
