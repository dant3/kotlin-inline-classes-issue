package com.example.backend

import io.micronaut.test.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import javax.inject.Inject


@MicronautTest(packages=["com.unison.backend"])
class NameRepositoryTest {
    @Inject internal lateinit var nameRepository: NameRepository

    @Test
    fun testStubRepository() {
        val exception = assertThrows<UnsupportedOperationException> {
            nameRepository.findNameById(Id(1))
        }
        assertEquals("STUB", exception.message)
    }
}
