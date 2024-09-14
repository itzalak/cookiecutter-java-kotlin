package io.template.app.api.controller.v1

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

class ApiControllerTest {

    private val mockMvc: MockMvc = MockMvcBuilders.standaloneSetup(ApiController()).build()

    @Test
    fun `should return successful string`() {
        mockMvc.perform(get("/v1/endpoint/1"))
            .andExpect(status().isOk)
            .andExpect(content().string("Successful"))
    }

    @Test
    fun `should return successful response when called with mockk`() {
        // Arrange
        val apiController = mockk<ApiController>()
        every { apiController.getEndpoint(1L) } returns "Successful"

        // Act
        val result = apiController.getEndpoint(1L)

        // Assert
        Assertions.assertEquals("Successful", result)

        // Verify the method was called with the right parameter
        verify { apiController.getEndpoint(1L) }
    }

    @Test
    fun `should return 404 for invalid endpoint`() {
        mockMvc.perform(get("/v1/invalidEndpoint/1"))
            .andExpect(status().isNotFound)
    }
}
