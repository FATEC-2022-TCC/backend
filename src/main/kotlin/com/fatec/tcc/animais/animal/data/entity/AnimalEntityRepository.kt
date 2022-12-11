package com.fatec.tcc.animais.animal.data.entity

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface AnimalEntityRepository : JpaRepository<AnimalEntity, Long> {
    @Query(
        "SELECT a.id AS id, a.picture AS picture, a.name AS name " +
        "FROM UserEntity u JOIN u.animals a " +
        "WHERE u.id = :userId " +
        "AND a.name LIKE %:name%"
    )
    fun findByNameAndUserId(
        name: String,
        userId: Long,
        page: Pageable
    ): Page<AnimalEntityProjection>

    @Query(
        "SELECT a FROM UserEntity u JOIN u.animals a " +
        "WHERE a.id = :animalId AND u.id = :userId"
    )
    fun findByUserIdAndAnimalId(
        userId: Long,
        animalId: Long,
    ): AnimalEntity?
}