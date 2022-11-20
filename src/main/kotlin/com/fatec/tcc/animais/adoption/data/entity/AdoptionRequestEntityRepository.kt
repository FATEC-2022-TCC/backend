package com.fatec.tcc.animais.adoption.data.entity

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface AdoptionRequestEntityRepository : JpaRepository<AdoptionRequestEntity, Long> {
    @Query(
        "SELECT r.id AS id, r.currentStatusCode AS currentStatusCode, r.createdBy AS createdBy " +
        "FROM AdoptionEntity a JOIN a.requests r WHERE (a.id = :id AND r.currentStatusCode = :currentStatusCode) AND r.createdBy LIKE %:text%"
    )
    fun searchAdoptionProjectionByAdoptionId(
        @Param("id") id: Long,
        @Param("text") text: String,
        @Param("currentStatusCode") currentStatusCode: Int,
        page: Pageable
    ): Page<AdoptionRequestEntityProjection>

    @Query(
        "SELECT r.id AS id, r.currentStatusCode AS currentStatusCode, r.createdBy AS createdBy " +
        "FROM AdoptionEntity ae JOIN ae.requests r WHERE r.createdBy = :createdBy AND ae.id = :adoptionId"
    )
    fun projectionByAdoptionIdAndCreatedBy(
        @Param("adoptionId") adoptionId: Long,
        @Param("createdBy") createdBy: String
    ): AdoptionRequestEntityProjection?
}