package io.github.oefff.documentation

import com.structurizr.Workspace
import com.structurizr.documentation.Section
import com.structurizr.documentation.StructurizrDocumentationTemplate
import com.structurizr.model.SoftwareSystem
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.File

@Configuration
class Documentation {

    @Bean
    fun documentationTemplate(workspace: Workspace): StructurizrDocumentationTemplate {
        return StructurizrDocumentationTemplate(workspace)
    }

    @Bean
    fun contextSection(oefff: SoftwareSystem, template: StructurizrDocumentationTemplate): Section {

        val resource = this::class.java.classLoader.getResource("io/github/oefff/documentation")
        val documentationRoot = File(resource.toURI())
        return template.addContextSection(oefff, File(documentationRoot, "01-context.md"))
    }


}
