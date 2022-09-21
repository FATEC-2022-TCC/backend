package com.fatec.tcc.animais.security

import org.springframework.beans.factory.ObjectProvider
import org.springframework.boot.autoconfigure.session.RedisSessionProperties
import org.springframework.boot.autoconfigure.session.SessionProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisOperations
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.StringRedisSerializer
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession
import org.springframework.session.data.redis.RedisSessionRepository
import java.time.Duration

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(RedisSessionProperties::class)
@EnableSpringHttpSession
class SessionConfig(
    private val sessionProperties: SessionProperties,
    private val redisSessionProperties: RedisSessionProperties,
    private val redisConnectionFactory: ObjectProvider<RedisConnectionFactory>
) {

    @Bean
    fun sessionRedisOperations(): RedisOperations<String, Any> {
        val redisTemplate = RedisTemplate<String, Any>()
        redisTemplate.setConnectionFactory(redisConnectionFactory.getObject())
        redisTemplate.keySerializer = StringRedisSerializer()
        redisTemplate.hashKeySerializer = StringRedisSerializer()
        return redisTemplate
    }

    @Bean
    fun sessionRepository(sessionRedisOperations: RedisOperations<String, Any>): RedisSessionRepository {
        val sessionRepository = RedisSessionRepository(sessionRedisOperations)
        val timeout: Duration? = sessionProperties.timeout
        if (timeout != null) {
            sessionRepository.setDefaultMaxInactiveInterval(timeout)
        }
        sessionRepository.setRedisKeyNamespace(redisSessionProperties.namespace)
        sessionRepository.setFlushMode(redisSessionProperties.flushMode)
        sessionRepository.setSaveMode(redisSessionProperties.saveMode)
        return sessionRepository
    }
}