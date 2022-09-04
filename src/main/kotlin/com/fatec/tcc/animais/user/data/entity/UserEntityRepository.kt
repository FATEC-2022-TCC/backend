package com.fatec.tcc.animais.user.data.entity

import com.fatec.tcc.animais.user.data.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UserEntityRepository : JpaRepository<UserEntity, Long> {
    @Query(
        "SELECT * FROM users WHERE username = ?1",
        nativeQuery = true
    )
    fun findByUsername(username: String): UserEntity?
}