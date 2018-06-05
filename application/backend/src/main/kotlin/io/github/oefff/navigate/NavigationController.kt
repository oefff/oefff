package io.github.oefff.navigate

import gherkin.ast.Feature
import io.github.oefff.api.Epic
import io.github.oefff.api.FeatureInfo
import io.github.oefff.api.Project
import io.github.oefff.review.FeatureService
import io.github.oefff.workspace.WorkspaceService
import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("projects")
class NavigationController(
        private val workspaceService: WorkspaceService,
        private val featureService: FeatureService
) {

    private val logger = KotlinLogging.logger { }

    @GetMapping()
    fun listProjects(): List<Project> = workspaceService.listProjects()

    @GetMapping("/{projectName}")
    fun getProject(
            @PathVariable projectName: String)
            : Project {

        logger.info("Going to read '$projectName' from workspace")
        return workspaceService.readProject(projectName)
    }


    @GetMapping("/{projectName}/epics")
    fun listEpicsInProject(
            @PathVariable projectName: String)
            : List<Epic> = featureService.listEpicsInProject(projectName)


    @GetMapping("/{projectName}/epics/{epicName}")
    fun getEpic(
            @PathVariable projectName: String,
            @PathVariable epicName: String)
            : Epic = featureService.readEpicInProject(projectName, epicName)


    @GetMapping("/{projectName}/epics/{}/features")
    fun listFeatures(
            @PathVariable projectName: String,
            @PathVariable epicName: String)
            : List<FeatureInfo> = featureService.listFeatureOfEpic(projectName, epicName)




    @GetMapping("/{projectName}/epics/{epicName}/features/{featureName}")
    fun reviewFeature(
            @PathVariable projectName: String,
            @PathVariable epicName: String,
            @PathVariable featureName: String): Feature {

        logger.info("Going to retrieve feature: $epicName/$featureName")

        return featureService.read("oefff", epicName, featureName)
    }

}
