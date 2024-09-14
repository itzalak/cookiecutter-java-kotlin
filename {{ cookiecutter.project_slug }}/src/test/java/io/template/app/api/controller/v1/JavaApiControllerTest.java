package io.template.app.api.controller.v1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@MockitoSettings
public class JavaApiControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private JavaApiController javaApiController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(javaApiController).build();
    }

    @Test
    void getEndpoint_shouldReturnSuccessfulResponse() throws Exception {
        // When + Then
        mockMvc.perform(get("/v0/endpoint/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Successful"));
    }

    @Test
    void getEndpoint_shouldReturn404ForInvalidUrl() throws Exception {
        // When + Then
        mockMvc.perform(get("/v0/invalidEndpoint/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void getEndpoint_shouldReturnCorrectResponseEntity() throws Exception {
        // Perform the GET request
        mockMvc.perform(get("/v0/endpoint/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Successful"));
    }

}
