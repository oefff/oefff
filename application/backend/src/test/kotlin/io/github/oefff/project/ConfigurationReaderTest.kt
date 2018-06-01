package io.github.oefff.project

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.endsWith
import org.junit.Test
import java.io.File

class ConfigurationReaderTest {

    @Test
    fun `it should be able to parse the custom config file`() {
        val relPath = javaClass.protectionDomain.codeSource.location.file
        val projectBaseDir : File = File(relPath).parentFile.parentFile.parentFile.parentFile



        assertThat(readConfig(projectBaseDir).specificationPath, endsWith("specifications/src/test/features/"))

    }
}
