package io.github.oefff.documentation.diagrams

import com.structurizr.model.Tags.PERSON

import com.structurizr.Workspace
import com.structurizr.model.Location
import com.structurizr.model.SoftwareSystem
import org.springframework.stereotype.Component

@Component
class Style(workspace: Workspace) {

    init {
        val styles = workspace.views.configuration.styles

        styles.addElementStyle(PERSON).shape(com.structurizr.view.Shape.Person)

        styles.addElementStyle("External").background("#aaaaaa")
        styles.addElementStyle("Internal").background("#000066").color("#ffffff")

        tagPeopleForStyling(workspace.model.people)
        tagSoftwareSystemsForStyling(workspace.model.softwareSystems)

    }

    private fun tagPeopleForStyling(people: Collection<com.structurizr.model.Person>) {
        people.forEach { person -> tagPersonBasedUponLocation(person, person.location) }
    }


    private fun tagSoftwareSystemsForStyling(softwareSystems: Collection<SoftwareSystem>) {
        softwareSystems.forEach { softwareSystem -> tagSystemsBasedUponLocation(softwareSystem, softwareSystem.location) }
    }

    private fun tagSystemsBasedUponLocation(softwareSystem: SoftwareSystem, location: Location) {
        when (location) {
            Location.Internal -> softwareSystem.addTags("Internal")
            Location.External -> softwareSystem.addTags("External")
            Location.Unspecified -> softwareSystem.addTags("Unspecified")
        }
    }

    private fun tagPersonBasedUponLocation(person: com.structurizr.model.Person, location: Location) {
        when (location) {
            Location.Internal -> person.addTags("Internal")
            Location.External -> person.addTags("External")
            Location.Unspecified -> person.addTags("Unspecified")
        }
    }


}
