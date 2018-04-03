package io.github.oefff.oefffbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OefffBackendApplication

fun main(args: Array<String>) {
    runApplication<OefffBackendApplication>(*args)
}
