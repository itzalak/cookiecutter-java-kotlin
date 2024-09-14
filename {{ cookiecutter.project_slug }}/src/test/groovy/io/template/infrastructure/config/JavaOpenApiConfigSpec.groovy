package io.template.infrastructure.config

import io.swagger.v3.oas.models.OpenAPI
import io.template.app.infrastructure.config.JavaOpenApiConfig
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import spock.lang.Specification

class JavaOpenApiConfigSpec extends Specification {

    def "should configure OpenAPI bean correctly"() {
        given:
        def context = new AnnotationConfigApplicationContext(JavaOpenApiConfig)
        def openAPI = context.getBean(OpenAPI)

        expect:
        openAPI != null
        openAPI.info.title == "Example API"
        openAPI.info.description == "Example description for API"
        openAPI.info.version == "v0.0.1"
    }
}
