package io.github.oefff.config

import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.AnnotationUtils
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition
import org.springframework.web.servlet.mvc.method.RequestMappingInfo
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping
import java.lang.reflect.Method

@Configuration
class ApiPrefixForRestControllerMappingHandlerMapping : RequestMappingHandlerMapping() {
    private val API_BASE_PATH = "api"

    override fun registerHandlerMethod(handler: Any, method: Method, mapping: RequestMappingInfo) {
        var mapping = mapping
        val beanType = method.getDeclaringClass()
        if (AnnotationUtils.findAnnotation(beanType, RestController::class.java) != null) {

            val apiPattern = PatternsRequestCondition(API_BASE_PATH).combine(mapping.patternsCondition)

            mapping = RequestMappingInfo(mapping.name, apiPattern,
                    mapping.methodsCondition, mapping.paramsCondition,
                    mapping.headersCondition, mapping.consumesCondition,
                    mapping.producesCondition, mapping.customCondition)
        }

        super.registerHandlerMethod(handler, method, mapping)
    }


}
