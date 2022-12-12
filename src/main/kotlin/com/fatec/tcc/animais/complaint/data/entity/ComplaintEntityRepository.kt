package com.fatec.tcc.animais.complaint.data.entity

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ComplaintEntityRepository : JpaRepository<ComplaintEntity, Long> {
    @Query(
        "SELECT c FROM ComplaintEntity c " +
        "WHERE (c.local LIKE %:text% OR c.description LIKE %:text%) " +
        "AND c.currentStatusCode = :currentStatusCode"
    )
    fun search(
        currentStatusCode: Int,
        text: String,
        page: Pageable
    ): Page<ComplaintEntityProjection>
}