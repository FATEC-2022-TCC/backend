package com.fatec.tcc.animais.security

import org.springframework.security.core.GrantedAuthority

data class CurrentUser(
    val id: Long,
    val username: String,
    val authorities: List<GrantedAuthority>
)