package com.fatec.tcc.animais.adoption.data.entity

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface AdoptionEntityRepository : JpaRepository<AdoptionEntity, Long> {
    @Query(
        "SELECT a FROM AdoptionEntity a WHERE " +
        "(a.name LIKE %:text% OR a.description LIKE %:text%) " +
        "AND a.gender LIKE %:gender% AND a.size LIKE %:size% " +
        "AND a.currentStatusCode IN :statuses"
    )
    fun search(
        text: String,
        gender: String,
        size: String,
        statuses: List<Int>,
        page: Pageable
    ): Page<AdoptionEntityProjection>

    @Query(
        "SELECT ae.id AS id, ae.name AS name, ae.description AS description, ae.picture AS picture " +
        "FROM AdoptionEntity ae " +
        "JOIN ae.requests r " +
        "WHERE r.createdBy = :createdBy " +
        "AND ae.name LIKE %:text%"
    )
    fun search(
        createdBy: String,
        text: String,
        page: Pageable
    ): Page<AdoptionEntityProjection>

    @Query(
        "SELECT ae " +
        "FROM AdoptionEntity ae " +
        "JOIN FETCH ae.requests r " +
        "WHERE r.createdBy = :createdBy " +
        "AND ae.id = :id"
    )
    fun findByCreatedByAndId(
        id: Long,
        createdBy: String
    ): AdoptionEntity?

    @Query(
        "SELECT ae " +
        "FROM AdoptionEntity ae " +
        "JOIN ae.requests r " +
        "WHERE r.id = :id"
    )
    fun findByAdoptionRequestId(
        id: Long
    ): AdoptionEntity?
}