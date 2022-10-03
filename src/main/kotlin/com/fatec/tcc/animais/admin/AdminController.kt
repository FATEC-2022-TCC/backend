package com.fatec.tcc.animais.admin

import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin
@RestController
@SecurityRequirement(name = "jwt")
@RequestMapping("/admin")
class AdminController {
    @GetMapping("/test")
    fun test(authentication: Authentication) =
        ResponseEntity.ok().build<Unit>()
}