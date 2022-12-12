package com.fatec.tcc.animais.adoption.data.entity

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface AdoptionRequestEntityRepository : JpaRepository<AdoptionRequestEntity, Long> {
    @Query(
        "SELECT r.id AS id, r.currentStatusCode AS currentStatusCode, r.createdBy AS createdBy " +
        "FROM AdoptionEntity ae " +
        "JOIN ae.requests r " +
        "WHERE (ae.id = :adoptionId AND r.currentStatusCode = :currentStatusCode) " +
        "AND r.createdBy LIKE %:text%"
    )
    fun search(
        adoptionId: Long,
        text: String,
        currentStatusCode: Int,
        page: Pageable
    ): Page<AdoptionRequestEntityProjection>

    @Query(
        "SELECT r.id AS id, r.currentStatusCode AS currentStatusCode, r.createdBy AS createdBy " +
        "FROM AdoptionEntity ae " +
        "JOIN ae.requests r " +
        "WHERE r.createdBy = :createdBy " +
        "AND ae.id = :adoptionId"
    )
    fun search(
        adoptionId: Long,
        createdBy: String
    ): AdoptionRequestEntityProjection?
}