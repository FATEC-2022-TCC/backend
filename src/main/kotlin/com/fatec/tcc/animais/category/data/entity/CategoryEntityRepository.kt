package com.fatec.tcc.animais.category.data.entity

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface CategoryEntityRepository : JpaRepository<CategoryEntity, Long> {

    @Query("SELECT c FROM CategoryEntity c WHERE c.description LIKE %:text%")
    fun searchProjection(
        @Param("text") text: String,
        page: Pageable
    ): Page<CategoryEntityProjection>

    @Query("SELECT c FROM CategoryEntity c")
    fun findAllProjection(): List<CategoryEntityProjection>
}