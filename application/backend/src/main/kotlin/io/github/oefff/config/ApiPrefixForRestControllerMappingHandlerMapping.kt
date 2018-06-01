package io.github.oefff.config

import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.AnnotationUtils
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition
import org.springframework.web.servlet.mvc.method.RequestMappingInfo
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping
import java.lang.reflect.Method

const val API_BASE_PATH = "api"

@Configuration
class ApiPrefixForRestControllerMappingHandlerMapping : RequestMappingHandlerMapping() {


    override fun registerHandlerMethod(handler: Any, method: Method, mapping: RequestMappingInfo) {

        val effectiveMapping = determineEffectiveMapping(method, mapping)
        super.registerHandlerMethod(handler, method, effectiveMapping)

    }

    private fun determineEffectiveMapping(method: Method, mapping: RequestMappingInfo): RequestMappingInfo =
            if (belongsToRestController(method)) {

                val apiPattern = PatternsRequestCondition(API_BASE_PATH).combine(mapping.patternsCondition)

                RequestMappingInfo(mapping.name, apiPattern,
                        mapping.methodsCondition, mapping.paramsCondition,
                        mapping.headersCondition, mapping.consumesCondition,
                        mapping.producesCondition, mapping.customCondition)
            } else {
                mapping
            }

    private fun belongsToRestController(method: Method) =
            AnnotationUtils.findAnnotation(method.getDeclaringClass(), RestController::class.java) != null


}
