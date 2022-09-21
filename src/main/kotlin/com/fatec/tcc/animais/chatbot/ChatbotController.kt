package com.fatec.tcc.animais.chatbot

import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller

@Controller
class ChatbotController {

    @MessageMapping("/chatbot/{sessionId}")
    @SendTo("/topic/chatbot/{sessionId}")
    fun greetings(@DestinationVariable sessionId: String, message: String): String {
        return "I received your message: $message"
    }
}