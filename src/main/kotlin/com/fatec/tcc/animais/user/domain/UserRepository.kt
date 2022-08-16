package com.fatec.tcc.animais.user.domain

interface UserRepository {
    fun all(): List<User>
    fun insert(user: User): User
}