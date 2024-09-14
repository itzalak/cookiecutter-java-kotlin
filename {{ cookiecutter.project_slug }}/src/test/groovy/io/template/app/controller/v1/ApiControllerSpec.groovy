package io.template.app.controller.v1

import io.template.app.JavaApplication
import io.template.app.api.controller.v1.JavaApiController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

@AutoConfigureMockMvc
@WebMvcTest(JavaApiController)
// required because there are multiple main files
@ContextConfiguration(classes = JavaApplication)
class ApiControllerSpec extends Specification {

    @Autowired
    private MockMvc mockMvc

    def "should return successful string"() {
        when:
        def result = mockMvc.perform(get("/v1/endpoint/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Successful"))

        then:
        result.andReturn().response.contentAsString == "Successful"
    }

    def "should return successful string for any valid ID"() {
        when:
        def result = mockMvc.perform(get("/v1/endpoint/999"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Successful"))

        then:
        result.andReturn().response.contentAsString == "Successful"
    }

    def "should return response with content type text/plain"() {
        when:
        def result = mockMvc.perform(get("/v1/endpoint/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=UTF-8"))

        then:
        result.andReturn().response.contentType == "text/plain;charset=UTF-8"
    }

}
