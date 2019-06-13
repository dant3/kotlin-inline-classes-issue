package com.example.backend

import io.micronaut.context.annotation.Primary
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.annotation.MicronautTest
import io.micronaut.test.annotation.MockBean
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito
import javax.inject.Inject


@MicronautTest(packages=["com.unison.backend"])
class HelloControllerTest {
    @Inject internal lateinit var server: EmbeddedServer
    @Inject internal lateinit var client: HelloClient
    @Inject internal lateinit var nameProvider: NameProvider

    @Test
    fun testHello() {
        given(nameProvider.getName()).willReturn("JUNIT")
        val greeting: Greeting = client.hello()
        assertNotNull(greeting)
        assertEquals(greeting.name, "JUNIT")
    }

    @Test
    fun testHelloWithName() {
        val firstName = FirstName("John")
        val greeting: Greeting = client.hello(firstName)
        assertNotNull(greeting)
        assertEquals(greeting.name, "John")
    }

    @Test
    fun testGreetMe() {
        val greeting: Greeting = client.greetMe(Name(Id(1), "UNIT-TEST"))
        assertNotNull(greeting)
        assertEquals(greeting.name, "UNIT-TEST")
    }

    @Primary
    @MockBean(NameProvider::class)
    fun mockNameProvider(): NameProvider = Mockito.mock(NameProvider::class.java)
}
