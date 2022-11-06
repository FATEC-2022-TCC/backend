package com.fatec.tcc.animais.chatbot

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.web.bind.annotation.*
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.concurrent.TimeUnit
import java.util.function.Supplier

@CrossOrigin
@RestController
@RequestMapping("/public/chatbot")
class ChatbotController(
    private val forkableChatbot: Supplier<Chatbot>
) {

    private val sessions = hashMapOf<String, Chatbot>()
    private val history = hashMapOf<String, Instant>()

    @PostMapping
    fun onMessage(
        @RequestBody chatbotRequest: ChatbotRequest
    ): ChatbotResponse {
        val (sessionId, message) = chatbotRequest
        val chatbot = sessions[sessionId] ?: forkableChatbot.get().also {
            sessions[sessionId] = it
            history[sessionId] = Instant.now()
        }
        return ChatbotResponse(
            message = chatbot(message),
            date = Instant.now()
        )
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