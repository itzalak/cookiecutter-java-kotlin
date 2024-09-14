package io.template.app.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JavaOpenApiConfigTest {

    @Test
    void apiV1_shouldReturnOpenAPIWithCorrectInfo() {
        // Given
        JavaOpenApiConfig config = new JavaOpenApiConfig();

        // When
        OpenAPI openAPI = config.apiV1();

        // Then
        assertThat(openAPI).isNotNull();
        assertThat(openAPI.getInfo()).isNotNull();
        assertThat(openAPI.getInfo().getTitle()).isEqualTo("Example API");
        assertThat(openAPI.getInfo().getDescription()).isEqualTo("Example description for API");
        assertThat(openAPI.getInfo().getVersion()).isEqualTo("v0.0.1");
    }
}
