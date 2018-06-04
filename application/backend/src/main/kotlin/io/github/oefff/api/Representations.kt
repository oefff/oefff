package io.github.oefff.api

data class Project(
        val name: String,
        val epics: List<Epic> = emptyList(),
        val featureNames: List<String> = emptyList())

data class Epic(
        val name: String,
        val features: List<String> = emptyList())

data class Feature(val name: String)
