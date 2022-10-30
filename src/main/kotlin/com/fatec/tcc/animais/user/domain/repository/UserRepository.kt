package com.fatec.tcc.animais.user.domain.repository

import com.fatec.tcc.animais.user.domain.model.User

interface UserRepository {
    fun findByUsername(username: String): User?
}