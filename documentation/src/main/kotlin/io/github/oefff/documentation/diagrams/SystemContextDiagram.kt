package io.github.oefff.documentation.diagrams

import cc.catalysts.boot.structurizr.ViewProvider
import com.structurizr.model.SoftwareSystem
import com.structurizr.view.ViewSet
import org.springframework.stereotype.Component

@Component
class SystemContextDiagram(val oefff: SoftwareSystem) : ViewProvider {
    override fun createViews(viewSet: ViewSet) {
        val systemContextView = viewSet.createSystemContextView(oefff, "Oefff", "Oefff")
        systemContextView.addAllPeople()
        systemContextView.addAllSoftwareSystems()
    }
}
