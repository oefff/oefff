package io.github.oefff.api

data class Project(val name: String)

data class Epic(val name: String, val features: List<String>)

data class Feature(val name: String)
