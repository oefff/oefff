package io.github.oefff.documentation

import com.structurizr.model.Location
import com.structurizr.model.Model
import com.structurizr.model.Person
import com.structurizr.model.SoftwareSystem
import com.structurizr.model.Tags.PERSON
import com.structurizr.model.Tags.SOFTWARE_SYSTEM
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class Actors {

    @Bean
    fun productOwner(model: Model): Person {
        val productOwnerPerson = model.addPerson(Location.Internal, "Product Owner", "Persons ultimately responsible for the product")
        productOwnerPerson.addTags(PERSON)
        return productOwnerPerson
    }


    @Bean
    fun gitRepository(model: Model): SoftwareSystem {
        val gitRepository = model.addSoftwareSystem(Location.External, "Git Repository", "Remote server containing the source code of a project")
        gitRepository.addTags(SOFTWARE_SYSTEM)
        return gitRepository
    }


}
