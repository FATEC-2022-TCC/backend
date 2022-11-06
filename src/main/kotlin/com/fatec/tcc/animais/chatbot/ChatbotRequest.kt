package com.fatec.tcc.animais.chatbot

data class ChatbotRequest(
    val sessionId: String,
    val message: String
)