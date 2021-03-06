package io.github.oefff.config

import io.github.oefff.workspace.WorkspaceLocationConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
@Profile("local")
class LocalConfiguration {

    @Bean
    fun configureWorkspaceLocation() = WorkspaceLocationConfiguration(true)
}
