package io.github.oefff.documentation

import com.structurizr.model.InteractionStyle.Synchronous
import com.structurizr.model.Location.Internal
import com.structurizr.model.Model
import com.structurizr.model.Person
import com.structurizr.model.SoftwareSystem
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SystemContext(
        private val model: Model,
        private val productOwner: Person,
        private val gitRepository: SoftwareSystem,
        private val developer: Person
    ) {

    @Bean
    fun oefff(): SoftwareSystem {

        val oefff = model.addSoftwareSystem(Internal, "Oefff", "Online Editor For Feature Files")
        productOwner.uses(oefff, "views and edits Feature Files online", "web", Synchronous)
        oefff.uses(gitRepository, "clones and pushed to", "ssh / https", Synchronous)
        developer.uses(gitRepository, "commits changes to", "ssh", Synchronous)
        return oefff
    }

}
