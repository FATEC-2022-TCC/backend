package com.fatec.tcc.animais.chatbot

import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/chatbot")
@SecurityRequirement(name = "jwt")
class ChatbotController(
    private val chatbot: Chatbot
)