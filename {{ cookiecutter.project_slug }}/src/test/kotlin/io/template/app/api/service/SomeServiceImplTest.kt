package io.itzalak.app.api.service

import io.itzalak.app.api.service.SomeServiceImpl
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@SpringBootTest
@ExtendWith(SpringExtension::class)
class SomeServiceImplTest(
    @Autowired private val service: SomeServiceImpl
) {
    @Test
    fun `get expected response`() {
        //when
        val result = service.someMethodReturningString()
        //then
        assertEquals(result, "some response!")
    }
}
