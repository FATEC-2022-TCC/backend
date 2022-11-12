package com.fatec.tcc.animais.category.data.repository

import com.fatec.tcc.animais.base.DefaultSearchableRepository
import com.fatec.tcc.animais.category.data.entity.CategoryEntityProjection
import com.fatec.tcc.animais.category.data.entity.CategoryEntityRepository
import com.fatec.tcc.animais.category.data.mapper.CategoryProjectionMapper
import com.fatec.tcc.animais.category.domain.model.CategoryProjection
import org.springframework.stereotype.Repository

@Repository
internal class CategoryProjectionRepositoryImpl(
    repository: CategoryEntityRepository,
    projectionMapper: CategoryProjectionMapper
) : DefaultSearchableRepository<CategoryProjection, CategoryEntityProjection, CategoryEntityRepository, String>(
    repository,
    projectionMapper,
    searchableMapper = { text, page -> searchProjection(text, page) }
)