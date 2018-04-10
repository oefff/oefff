package io.github.oefff.documentation

import com.structurizr.Workspace
import com.structurizr.model.Model
import com.structurizr.view.ViewSet
import org.springframework.boot.SpringApplication
import org.springframework.boot.SpringBootConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.ComponentScans

@SpringBootConfiguration
@ComponentScans(ComponentScan("cc.catalysts.boot.structurizr"), ComponentScan("io.github.oefff"))
class ArchitectureDocumentationGenerator {

    @Bean
    fun workspace(): Workspace {
        return Workspace("SystemContext", "Online Editor For Feature Files")

    }

    @Bean
    fun model(workspace: Workspace): Model {
        return workspace.model
    }

    @Bean
    fun views(workspace: Workspace): ViewSet {
        return workspace.views
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(ArchitectureDocumentationGenerator::class.java, *args)
        }
    }
}
