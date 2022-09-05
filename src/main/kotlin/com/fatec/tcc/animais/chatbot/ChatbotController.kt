package com.fatec.tcc.animais.chatbot

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller

@Controller
class ChatbotController {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    fun greetings(message: String): String {
        return "I received you message: $message"
    }
}