package com.fatec.tcc.animais.content.data.entity

import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ContentEntityRepository : PagingAndSortingRepository<ContentEntity, Long> {
    @Query("SELECT c FROM ContentEntity c WHERE c.until <= :date")
    fun findUntilDate(
        @Param("date") date: Date
    ): List<ContentEntity>

    @Query("SELECT c FROM ContentEntity c")
    fun findProjection(): List<ContentProjectionEntity>

    @Query("SELECT c FROM ContentEntity c WHERE c.until >= :date")
    fun findProjectionUntilDate(
        @Param("date") date: Date,
        sort: Sort
    ): List<ContentProjectionEntity>
}