package com.fatec.tcc.animais.user.data.entity

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UserEntityRepository : JpaRepository<UserEntity, Long> {
    fun findByUsername(username: String): UserEntity?
    fun findByIsValidated(isValidated: Boolean): List<UserEntity>

    @Query(
        "SELECT u.id AS id, u.name AS name, u.username AS username, u.isActive AS isActive, u.isValidated AS isValidated " +
        "FROM UserEntity u " +
        "WHERE u.isActive = :isActive " +
        "AND u.isValidated = :isValidated " +
        "AND (u.name LIKE %:text% OR u.username LIKE %:text%)"
    )
    fun search(
        text: String,
        isActive: Boolean,
        isValidated: Boolean,
        page: Pageable
    ): Page<UserEntityProjection>
}