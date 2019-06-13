package com.example.backend

import javax.inject.Singleton

@Singleton
class DefaultNameProvider: NameProvider {
    override fun getName(): String = "Micronaut"
}