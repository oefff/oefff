package io.github.oefff.documentation

import com.structurizr.model.InteractionStyle.Synchronous
import com.structurizr.model.Model
import com.structurizr.model.Person
import com.structurizr.model.SoftwareSystem
import org.springframework.beans.factory.InitializingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SystemContext(model: Model, val productOwner: Person, val gitRepository: SoftwareSystem): InitializingBean{


    private final val oefff = model.addSoftwareSystem("Oefff", "Online Editor For Feature Files")

    override fun afterPropertiesSet() {
        productOwner.uses(oefff, "views and edits Feature Files online", "web", Synchronous)
        oefff.uses(gitRepository, "clones and pushed to", "ssh / https" ,Synchronous)

    }


    @Bean
    fun oefff(): SoftwareSystem {
        return this.oefff
    }

}
