package com.fatec.tcc.animais.compliant.data.entity

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface CompliantEntityRepository : JpaRepository<CompliantEntity, Long> {
    @Query("SELECT c FROM CompliantEntity c WHERE c.local LIKE %:text% OR c.description LIKE %:text%")
    fun searchProjection(
        @Param("text") text: String,
        page: Pageable
    ): Page<CompliantEntityProjection>
}