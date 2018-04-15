package io.github.oefff.config

import mu.KotlinLogging
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping


@Configuration
class OefffWebMvcConfiguration : WebMvcConfigurationSupport() {


    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**").allowedOrigins("http://localhost:4200")
    }

    override fun createRequestMappingHandlerMapping(): RequestMappingHandlerMapping {
        return ApiPrefixForRestControllerMappingHandlerMapping()
    }


}
