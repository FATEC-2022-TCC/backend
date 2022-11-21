package com.fatec.tcc.animais.chatbot

import base.DefaultNodeManager
import base.DefaultNodeManagerBuilder
import extension.use
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.util.ResourceUtils
import parser.Parser
import parser.json.JSONParseImpl
import parser.json.Knowledge
import java.io.FileInputStream
import java.util.function.Supplier

@Component
class ChatbotConfiguration {
    class ChatbotImpl(
        private val defaultNodeManager: DefaultNodeManager
    ) : Chatbot {
        override fun invoke(message: String) = defaultNodeManager.find(message)
    }

    @Bean
    fun providesChatbotSupplier() = object : Supplier<Chatbot> {
        val parser: Parser<Knowledge> = JSONParseImpl(Knowledge::class)

        val files = ResourceUtils.getFile("classpath:bots/joselito/").listFiles() ?: emptyArray()
        val data = files.map(::FileInputStream).use(parser::parse)

        val defaultNodeManager = DefaultNodeManagerBuilder.build(data)

        override fun get() = defaultNodeManager.get().run(::ChatbotImpl)
    }
}