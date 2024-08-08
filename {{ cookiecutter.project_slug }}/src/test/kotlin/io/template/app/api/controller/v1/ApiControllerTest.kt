package io.itzalak.app.api.controller.v1

import io.itzalak.app.api.controller.v1.ApiController
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@ExtendWith(SpringExtension::class)
@WebMvcTest(ApiController::class)
class ApiControllerTest {


    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    @DirtiesContext
    fun wheEndpointIsCalled_thenResultIsSuccessful() {
        //when
        mockMvc.get("/v1/endpoint/{id}", 11) {
            contentType = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
        }
    }
}
