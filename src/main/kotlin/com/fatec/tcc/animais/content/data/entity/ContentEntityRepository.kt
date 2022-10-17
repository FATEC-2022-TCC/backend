package com.fatec.tcc.animais.content.data.entity

import com.fatec.tcc.animais.content.domain.model.ContentProjection
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ContentEntityRepository : JpaRepository<ContentEntity, Long> {
    @Query("SELECT c FROM ContentEntity c WHERE c.until <= :date")
    fun findUntilDate(
        @Param("date") date: Date
    ): List<ContentEntity>

    @Query("SELECT c FROM ContentEntity c")
    fun findProjection(): List<ContentProjection>
}