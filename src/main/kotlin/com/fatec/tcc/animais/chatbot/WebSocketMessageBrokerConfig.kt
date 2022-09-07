package com.fatec.tcc.animais.chatbot

import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.session.Session
import org.springframework.session.web.socket.config.annotation.AbstractSessionWebSocketMessageBrokerConfigurer
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry

@Configuration
@EnableWebSocketMessageBroker
@EnableScheduling
class WebSocketMessageBrokerConfig : AbstractSessionWebSocketMessageBrokerConfigurer<Session>() {
    override fun configureStompEndpoints(registry: StompEndpointRegistry) {
        registry.addEndpoint("/ws")
    }

    override fun configureMessageBroker(registry: MessageBrokerRegistry) {
        registry.setApplicationDestinationPrefixes("/app")
        registry.enableSimpleBroker("/topic")
    }
}