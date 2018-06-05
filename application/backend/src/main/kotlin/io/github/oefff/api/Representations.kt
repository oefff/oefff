package io.github.oefff.api

data class Project(
        val name: String,
        val epicNames: List<EpicInfo> = emptyList(),
        val featureNames: List<FeatureInfo> = emptyList())

data class EpicInfo(val name: String)


data class Epic(
        val name: String,
        val features: List<FeatureInfo> = emptyList())


data class FeatureInfo(val name: String)

data class Feature(val name: String)
