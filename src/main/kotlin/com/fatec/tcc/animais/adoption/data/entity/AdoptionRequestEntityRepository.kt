package com.fatec.tcc.animais.adoption.data.entity

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface AdoptionRequestEntityRepository : JpaRepository<AdoptionRequestEntity, Long> {
    @Query("SELECT r FROM AdoptionEntity a JOIN a.requests r WHERE a.id = :id AND r.createdBy LIKE %:text%")
    fun searchAdoptionProjectionByAdoptionId(
        @Param("id") id: Long,
        @Param("text") text: String,
        page: Pageable
    ): Page<AdoptionRequestEntityProjection>

    @Query("SELECT a FROM AdoptionRequestEntity a WHERE a.createdBy = :createdBy")
    fun getByCreatedBy(
        @Param("createdBy") createdBy: String
    ): AdoptionRequestEntityProjection?
}