package com.fatec.tcc.animais

import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/prod")
class TrustedTestController {

    @GetMapping("/helloworld")
    fun helloWorld(authentication: Authentication): String {
        println(authentication)
        return "Hello World"
    }
}