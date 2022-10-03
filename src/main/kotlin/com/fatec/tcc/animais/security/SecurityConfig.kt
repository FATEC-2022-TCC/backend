package com.fatec.tcc.animais.security

import com.nimbusds.jose.jwk.JWK
import com.nimbusds.jose.jwk.JWKSet
import com.nimbusds.jose.jwk.RSAKey
import com.nimbusds.jose.jwk.source.ImmutableJWKSet
import com.nimbusds.jose.jwk.source.JWKSource
import com.nimbusds.jose.proc.SecurityContext
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.oauth2.jwt.*
import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationEntryPoint
import org.springframework.security.oauth2.server.resource.web.access.BearerTokenAccessDeniedHandler
import org.springframework.security.web.SecurityFilterChain
import java.security.interfaces.RSAPrivateKey
import java.security.interfaces.RSAPublicKey

@Configuration
class SecurityConfig(
    @Value("\${jwt.public.key}")
    private val pub: RSAPublicKey,
    @Value("\${jwt.private.key}")
    private val priv: RSAPrivateKey
) {
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        return http.cors().and().csrf().disable()
            .sessionManagement {
                it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            }
            .oauth2ResourceServer(OAuth2ResourceServerConfigurer<HttpSecurity>::jwt)
            .exceptionHandling {
                it.authenticationEntryPoint(
                    BearerTokenAuthenticationEntryPoint()
                )
                it.accessDeniedHandler(
                    BearerTokenAccessDeniedHandler()
                )
            }
            .authorizeHttpRequests()
            //swagger route
            .antMatchers("/swagger**/**", "/v3/api-docs**/**")
            .permitAll()
            //create and generate token route
            .antMatchers(HttpMethod.POST,  "/user", "/user/login")
            .permitAll()
            .antMatchers("/ws/**")
            .permitAll()
            .antMatchers("/admin/**")
            .hasAuthority("SCOPE_ADMIN")
            .and()
            .authorizeHttpRequests()
            .anyRequest()
            .authenticated()
            .and()
            .build()
    }

    @Bean
    fun jwtDecoder(): JwtDecoder = NimbusJwtDecoder.withPublicKey(pub).build()

    @Bean
    fun jwtEncoder(): JwtEncoder {
        val jwk: JWK = RSAKey.Builder(pub).privateKey(priv).build()
        val jwks: JWKSource<SecurityContext> = ImmutableJWKSet(JWKSet(jwk))
        return NimbusJwtEncoder(jwks)
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

//    @Bean
//    fun currentUser(authentication: Authentication): CurrentUser {
//        val jwt = authentication.credentials as? Jwt
//        val id = (jwt?.claims?.get("jti") as? String)?.toLong() ?: -1L
//        val username = authentication.principal as? String ?: ""
//        val authorities = authentication.authorities.toList()
//        return CurrentUser(
//            id,
//            username,
//            authorities
//        )
//    }
}