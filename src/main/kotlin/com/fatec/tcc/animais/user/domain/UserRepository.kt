package com.fatec.tcc.animais.user.domain

interface UserRepository {
    fun all(): List<User>
    fun insert(user: User): User
    fun find(id: Long): User?
    fun find(username: String): User?
    fun update(user: User): User
}