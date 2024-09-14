package io.template.app.api.service

import org.springframework.stereotype.Service

@Service
class SomeServiceImpl : SomeService {
    override fun someMethodReturningString(): String = "some response!"
}
