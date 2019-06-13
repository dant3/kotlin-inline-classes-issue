package com.example.backend.aop

import io.micronaut.aop.Introduction
import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Type

@Bean
@Introduction
@Type(StubIntroduction::class)
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.TYPE, AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.CLASS)
annotation class Stub()