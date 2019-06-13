package com.example.backend

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*

interface HelloApi {
    @Get("/")
    @Produces(MediaType.APPLICATION_JSON)
    fun hello(): Greeting

    @Get("/")
    @Produces(MediaType.APPLICATION_JSON)
    fun hello(@QueryValue firstName: FirstName): Greeting

    @Post("/greetMe")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun greetMe(@Body request: Name): Greeting
}

inline class Id(val raw: Int)
inline class FirstName(val name: String)
data class Name(val id: Id, val name: String)
