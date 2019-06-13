package com.example.backend

import com.example.backend.aop.Stub

@Stub
interface NameRepository {
    fun findNameById(id: Id): Name?
}