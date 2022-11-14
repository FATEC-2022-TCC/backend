package com.fatec.tcc.animais.adoption.data.entity

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface AdoptionEntityRepository : JpaRepository<AdoptionEntity, Long> {
    @Query("SELECT a FROM AdoptionEntity a WHERE (a.name LIKE %:text% OR a.description LIKE %:text%) AND a.currentStatusCode = :currentStatusCode")
    fun searchProjection(
        @Param("currentStatusCode") currentStatusCode: Int,
        @Param("text") text: String,
        page: Pageable
    ): Page<AdoptionEntityProjection>

    @Query("SELECT a FROM AdoptionEntity a")
    fun projection(
        page: Pageable
    ): Page<AdoptionEntityProjection>
}