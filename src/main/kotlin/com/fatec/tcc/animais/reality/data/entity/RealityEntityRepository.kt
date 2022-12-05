package com.fatec.tcc.animais.reality.data.entity

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface RealityEntityRepository : JpaRepository<RealityEntity, Long> {
    @Query(
        "SELECT r.id AS id, r.title AS title, r.background AS background, r.isVisible AS isVisible " +
        "FROM RealityEntity r " +
        "WHERE (r.title LIKE %:text% OR r.description LIKE %:text%) " +
        "AND r.isVisible = :isVisible"
    )
    fun search(
        text: String,
        isVisible: Boolean,
        page: Pageable
    ): Page<RealityEntityProjection>
}