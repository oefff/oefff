package io.github.oefff.documentation

import com.structurizr.Workspace
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
    fun contextSection(oefff: SoftwareSystem, template: StructurizrDocumentationTemplate) =
            template.addContextSection(oefff, fetchFile("01-context.md"))

    @Bean
    fun functionalOverview(oefff: SoftwareSystem, template: StructurizrDocumentationTemplate) =
            template.addContextSection(oefff, fetchFile("02-functional-overview.md"))


    @Bean
    fun decisionLog(oefff: SoftwareSystem, template: StructurizrDocumentationTemplate) =
            template.addDecisionLogSection(oefff, fetchFile("15-decision-log.md"))


    private fun fetchFile(fileName: String): File {
        val resource = this::class.java.classLoader.getResource("io/github/oefff/documentation")
        val documentationRoot = File(resource.toURI())
        return File(documentationRoot, fileName)
    }




    /* * <ul>
 *     01 Context (1)</li>
 *     02 Functional Overview (2)</li>
 *     03 Quality Attributes (2)</li>
 *     04 Constraints (2)</li>
 *     05 Principles (2)</li>
 *     06 Software Architecture (3)</li>
 *     07 Containers (3)</li>
 *     08 Components (3)</li>
 *     09 Code (3)</li>
 *     10 Data (3)</li>
 *     11 Infrastructure Architecture (4)</li>
 *     12 Deployment (4)</li>
 *     13 Development Environment (4)</li>
 *     14 Operation and Support (4)</li>
 *     15 Decision Log (5)</li>
 * </ul>

*/
}
