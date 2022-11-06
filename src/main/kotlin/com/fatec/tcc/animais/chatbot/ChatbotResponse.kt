package com.fatec.tcc.animais.chatbot

import java.time.Instant

data class ChatbotResponse(
    val message: String,
    val date: Instant
)