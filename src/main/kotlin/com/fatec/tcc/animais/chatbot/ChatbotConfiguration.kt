package com.fatec.tcc.animais.chatbot

import base.processor.NodeManager
import extension.use
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.util.ResourceUtils
import parser.Parser
import parser.json.Aiml
import parser.json.JSONParseImpl
import java.io.FileInputStream
import java.util.function.Supplier

@Component
class ChatbotConfiguration {
    class ChatbotImpl(
        private val nodeManager: NodeManager
    ) : Chatbot {
        override fun invoke(message: String) = nodeManager.find(message)
    }

    @Bean
    fun providesChatbotSupplier(): Supplier<Chatbot> = object : Supplier<Chatbot> {
        val parser: Parser<Aiml> = JSONParseImpl(Aiml::class)

        val files = ResourceUtils.getFile("classpath:bots/joselito/").listFiles() ?: emptyArray()
        val data = files.map(::FileInputStream).use(parser::parse)
        val nodeManager = NodeManager.build(data)

        override fun get() = nodeManager.get().run(::ChatbotImpl)
    }
}