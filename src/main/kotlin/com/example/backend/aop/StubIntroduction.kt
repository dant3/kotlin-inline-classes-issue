package com.example.backend.aop

import io.micronaut.aop.MethodInterceptor
import io.micronaut.aop.MethodInvocationContext
import javax.inject.Singleton

@Singleton
class StubIntroduction : MethodInterceptor<Any, Any> {
    override fun intercept(context: MethodInvocationContext<Any, Any>): Any? {
        throw UnsupportedOperationException("STUB!")
    }
}