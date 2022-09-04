package com.fatec.tcc.animais.user.data.entity

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserEntityRepository : JpaRepository<UserEntity, Long> {
    fun findByUsername(username: String): UserEntity?
}