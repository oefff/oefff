package io.github.oefff.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping


@Configuration
class OefffWebMvcConfiguration : WebMvcConfigurationSupport() {

    val CLASSPATH_RESOURCE_LOCATIONS = arrayOf(
            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/static/", "classpath:/public/")

    override fun configureDefaultServletHandling(configurer: DefaultServletHandlerConfigurer) {
        configurer.enable()
    }


    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**").allowedOrigins("http://localhost:4200")
    }

    override fun createRequestMappingHandlerMapping(): RequestMappingHandlerMapping {
        return ApiPrefixForRestControllerMappingHandlerMapping()
    }

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {

        if (!registry.hasMappingForPattern("/webjars/**")) {
            registry.addResourceHandler("/webjars/**").addResourceLocations(
                    "classpath:/META-INF/resources/webjars/")
        }
        if (!registry.hasMappingForPattern("/**")) {
            CLASSPATH_RESOURCE_LOCATIONS.forEach {
                registry.addResourceHandler("/**").addResourceLocations(it)
            }
        }
    }


}


