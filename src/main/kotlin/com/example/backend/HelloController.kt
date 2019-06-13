package com.example.backend

import io.micronaut.http.annotation.Controller
import java.util.concurrent.atomic.AtomicLong

@Controller("/hello")
class HelloController(private val nameProvider: NameProvider, private val helloClient: HelloClient): HelloApi {
    private val counter = AtomicLong(0)

    override fun hello(firstName: FirstName): Greeting {
        return Greeting(firstName.name)
    }

    override fun hello(): Greeting {
        if (counter.incrementAndGet() % 2 == 0L) {
            return Greeting(nameProvider.getName())
        } else {
            println("Querying with client...")
            return helloClient.hello()
        }
    }

    override fun greetMe(request: Name): Greeting {
        return Greeting(request.name)
    }
}