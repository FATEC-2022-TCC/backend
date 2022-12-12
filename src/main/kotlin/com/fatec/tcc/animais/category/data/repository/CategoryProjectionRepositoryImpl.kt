package com.fatec.tcc.animais.category.data.repository

import com.fatec.tcc.animais.base.DefaultSearchableRepository
import com.fatec.tcc.animais.category.data.entity.CategoryEntityProjection
import com.fatec.tcc.animais.category.data.entity.CategoryEntityRepository
import com.fatec.tcc.animais.category.data.mapper.CategoryProjectionMapper
import com.fatec.tcc.animais.category.domain.model.CategoryProjection
import com.fatec.tcc.animais.category.domain.repository.CategoryProjectionRepository
import org.springframework.stereotype.Repository

@Repository
internal class CategoryProjectionRepositoryImpl(
    private val repository: CategoryEntityRepository,
    private val projectionMapper: CategoryProjectionMapper
) : DefaultSearchableRepository<CategoryProjection, CategoryEntityProjection, CategoryEntityRepository, String>(
    repository,
    projectionMapper,
    searchableMapper = { text, page -> search(text, page) }
), CategoryProjectionRepository {
    override fun all() = repository.findAllProjection().map(projectionMapper::toDomain)
}