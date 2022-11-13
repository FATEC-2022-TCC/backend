package com.fatec.tcc.animais.category.domain.repository

import com.fatec.tcc.animais.category.domain.model.CategoryProjection

interface CategoryProjectionRepository {
    fun all(): List<CategoryProjection>
}