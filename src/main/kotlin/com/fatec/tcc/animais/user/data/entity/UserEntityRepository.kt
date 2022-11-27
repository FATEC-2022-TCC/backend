package com.fatec.tcc.animais.user.data.entity

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UserEntityRepository : JpaRepository<UserEntity, Long> {
    fun findByUsername(username: String): UserEntity?

    @Query(
        "SELECT u.id AS id, u.username AS username FROM UserEntity u " +
        "WHERE u.isActive = :isActive " +
        "AND (u.name LIKE %:text% OR u.username LIKE %:text%)"
    )
    fun search(
        isActive: Boolean,
        text: String,
        page: Pageable
    ): Page<UserEntityProjection>
}