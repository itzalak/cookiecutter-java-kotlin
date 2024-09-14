package io.template.app.api.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SomeServiceImplTest {
    @Test
    fun `someMethodReturningString should return expected response`() {
        // Given
        val someService = SomeServiceImpl()

        // When
        val result = someService.someMethodReturningString()

        // Then
        assertEquals("some response!", result)
    }
}
