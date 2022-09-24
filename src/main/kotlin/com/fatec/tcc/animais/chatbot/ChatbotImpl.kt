package com.fatec.tcc.animais.chatbot

import org.springframework.stereotype.Component

@Component
class ChatbotImpl : Chatbot {
    val stack = arrayListOf<String>()

    override fun invoke(message: String): String {
        stack += message
        return "Will be implemented: ${stack.size}"
    }
}