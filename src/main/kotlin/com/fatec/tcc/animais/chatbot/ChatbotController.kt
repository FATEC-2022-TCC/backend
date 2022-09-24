package com.fatec.tcc.animais.chatbot

import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Controller
import java.time.Instant
import java.util.concurrent.TimeUnit

@Controller
class ChatbotController {

    private val sessions = hashMapOf<String, Chatbot>()
    private val history = hashMapOf<String, Instant>()
    private val maxSeconds = 60L

    @MessageMapping("/chatbot/{sessionId}")
    @SendTo("/topic/chatbot/{sessionId}")
    fun onMessage(@DestinationVariable sessionId: String, message: String): String {
        val chatbot = sessions[sessionId] ?: ChatbotImpl().also {
            sessions[sessionId] = it
            history[sessionId] = Instant.now()
        }
        return chatbot(message)
    }

    @Scheduled(fixedRate = 1, timeUnit = TimeUnit.MINUTES)
    fun onClean() {
        val toRemove = mutableSetOf<String>()
        val now = Instant.now()
        for ((key, instant) in history) {
            val diff = instant.plusSeconds(maxSeconds)
            if (diff.isBefore(now)) toRemove += key
        }
        sessions -= toRemove
        history -= toRemove
    }
}