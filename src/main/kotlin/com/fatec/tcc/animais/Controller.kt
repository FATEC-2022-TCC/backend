package com.fatec.tcc.animais

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {

    @GetMapping("/helloworld")
    fun helloWorld() = "Hello World"
}