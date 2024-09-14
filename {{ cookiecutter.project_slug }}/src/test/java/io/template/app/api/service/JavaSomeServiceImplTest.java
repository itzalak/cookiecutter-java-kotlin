package io.template.app.api.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JavaSomeServiceImplTest {

    @Test
    void someMethodReturningString_shouldReturnExpectedResponse() {
        // Given
        JavaSomeServiceImpl service = new JavaSomeServiceImpl();

        // When
        String response = service.someMethodReturningString();

        // Then
        assertThat(response).isNotNull();
        assertThat(response).isEqualTo("Successful");
    }

    @Test
    void someMethodReturningString_shouldNotReturnEmpty() {
        // Given
        JavaSomeServiceImpl service = new JavaSomeServiceImpl();

        // When
        String response = service.someMethodReturningString();

        // Then
        assertThat(response).isNotEmpty();
    }

    @Test
    void someMethodReturningString_shouldContainResponseKeyword() {
        // Given
        JavaSomeServiceImpl service = new JavaSomeServiceImpl();

        // When
        String response = service.someMethodReturningString();

        // Then
        assertThat(response).contains("Successful");
    }
}
