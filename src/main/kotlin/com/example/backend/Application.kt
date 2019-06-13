package com.example.backend

import io.micronaut.runtime.Micronaut

object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("com.unison.backend")
                .mainClass(Application.javaClass)
                .start()
    }
}
