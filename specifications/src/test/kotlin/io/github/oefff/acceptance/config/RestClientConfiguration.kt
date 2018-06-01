package io.github.oefff.acceptance.config

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.PropertyAccessor
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.github.oefff.acceptance.OefffFeature
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate


@Configuration
class RestClientConfiguration {

    @Bean
    fun restTemplate(): RestTemplate {
        return RestTemplate()
    }

    @Bean
    fun objectMapper(): ObjectMapper {


        val objectMapper = ObjectMapper()
                .registerModule(KotlinModule())

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)

//        // http://www.baeldung.com/jackson-deserialization
//        val module = SimpleModule()
//        val d
//        module.addDeserializer(Feature::class.java, d)
        return objectMapper

    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val configuration = RestClientConfiguration()
            val objectMapper = configuration.objectMapper()

            val json = """{"location":{"line":1,"column":1},
                "tags":[],"language":"en","keyword":"OefffFeature",
                "name":"Display an existing feature",
                "description":"  In order to review a specification\n  As the Product Owner\n  I want to see one of the existing feature files",
                "children":[{"location":{"line":8,"column":1},"keyword":"Scenario","name":"Marco views the displayFeature-feature","description":null,"steps":[{"location":{"line":10,"column":3},"keyword":"Given ","text":"the displayFeature has been written and is part of the existing project","argument":null},{"location":{"line":11,"column":4},"keyword":"When ","text":"Marco selects that feature for review","argument":null},{"location":{"line":12,"column":4},"keyword":"Then ","text":"the displayFeature should be displayed","argument":null}],"tags":[]}]}
                """

            val feature = objectMapper.readValue(json, OefffFeature::class.java)
            println(feature.name)

        }
    }
}
