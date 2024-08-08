package io.itzalak.app.api.service

import io.itzalak.app.api.service.SomeService
import org.springframework.stereotype.Service

@Service
class SomeServiceImpl : SomeService {
    override fun someMethodReturningString(): String {
        return "some response!"
    }
}
