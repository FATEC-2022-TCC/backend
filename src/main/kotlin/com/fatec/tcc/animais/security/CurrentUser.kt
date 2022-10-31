package com.fatec.tcc.animais.security

import org.springframework.http.HttpStatus
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.web.server.ResponseStatusException

data class CurrentUser(
    val id: Long,
    val username: String,
    val authorities: List<GrantedAuthority>
)

fun Authentication.toCurrentUser(): CurrentUser {
    val jwt = credentials as? Jwt ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST)
    val id = (jwt.claims?.get("jti") as? String)?.toLong() ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST)
    val username = name ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST)
    val authorities = authorities.toList()
    if (authorities.isEmpty()) throw ResponseStatusException(HttpStatus.BAD_REQUEST)
    return CurrentUser(
        id,
        username,
        authorities
    )
}