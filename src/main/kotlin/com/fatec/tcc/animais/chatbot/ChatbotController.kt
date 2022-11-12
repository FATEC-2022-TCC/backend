package com.fatec.tcc.animais.chatbot

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.web.bind.annotation.*
import java.text.Normalizer
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
    private val regex = "\\p{InCombiningDiacriticalMarks}+".toRegex()

    @PostMapping
    fun onMessage(
        @RequestBody request: ChatbotRequest
    ): ChatbotResponse {
        val (sessionId, message) = request
        val chatbot = sessions[sessionId] ?: forkableChatbot.get().also {
            sessions[sessionId] = it
            history[sessionId] = Instant.now()
        }
        val normalized = Normalizer
            .normalize(message.lowercase(), Normalizer.Form.NFD)
            .replace(regex, "")
        return ChatbotResponse(
            message = chatbot(normalized),
            date = Instant.now()
        )
    }

    @Scheduled(fixedRate = 15, timeUnit = TimeUnit.MINUTES)
    private fun onClean() {
        val toRemove = mutableSetOf<String>()
        val now = Instant.now()
        for ((key, instant) in history) {
            val diff = instant.plus(15, ChronoUnit.MINUTES)
            if (diff.isBefore(now)) toRemove += key
        }
        sessions -= toRemove
        history -= toRemove
    }
}