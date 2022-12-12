package com.fatec.tcc.animais.content.data.entity

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.time.Instant
import java.util.*

@Repository
interface ContentEntityRepository : JpaRepository<ContentEntity, Long> {
    @Query("SELECT c FROM ContentEntity c WHERE c.until >= :date")
    fun search(
        instant: Instant,
        sort: Sort
    ): List<ContentEntityProjection>

    @Query(
        "SELECT c FROM ContentEntity c " +
        "WHERE c.title LIKE %:text% " +
        "OR c.description LIKE %:text% " +
        "OR c.data LIKE %:text%"
    )
    fun search(
        text: String,
        page: Pageable
    ): Page<ContentEntityProjection>
}