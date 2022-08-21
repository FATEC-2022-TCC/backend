package com.fatec.tcc.animais.chatbot

import org.alicebot.ab.Bot
import org.springframework.stereotype.Component

@Component
class ChatbotImpl : Chatbot {
    val bot = Bot()
}