package com.fatec.tcc.animais.chatbot

interface Chatbot {
    operator fun invoke(message: String): String
}