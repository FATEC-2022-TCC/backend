package com.fatec.tcc.animais.category.data.entity

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryEntityRepository : JpaRepository<CategoryEntity, Long>