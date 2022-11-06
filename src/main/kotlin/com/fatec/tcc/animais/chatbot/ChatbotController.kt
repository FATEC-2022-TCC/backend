package com.fatec.tcc.animais.chatbot

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.concurrent.TimeUnit

@CrossOrigin
@RestController("/public/chatbot")
class ChatbotController {

    private val sessions = hashMapOf<String, Chatbot>()
    private val history = hashMapOf<String, Instant>()

    @PostMapping
    fun onMessage(chatbotMessage: ChatbotMessage): String {
        val (sessionId, message) = chatbotMessage
        val chatbot = sessions[sessionId] ?: ChatbotImpl().also {
            sessions[sessionId] = it
            history[sessionId] = Instant.now()
        }
        return chatbot(message)
    }

    @Scheduled(fixedRate = 1, timeUnit = TimeUnit.MINUTES)
    private fun onClean() {
        val toRemove = mutableSetOf<String>()
        val now = Instant.now()
        for ((key, instant) in history) {
            val diff = instant.plus(1, ChronoUnit.MINUTES)
            if (diff.isBefore(now)) toRemove += key
        }
        sessions -= toRemove
        history -= toRemove
    }
}