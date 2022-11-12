package com.fatec.tcc.animais.category.data.repository

import com.fatec.tcc.animais.base.DefaultRepository
import com.fatec.tcc.animais.category.data.entity.CategoryEntity
import com.fatec.tcc.animais.category.data.entity.CategoryEntityRepository
import com.fatec.tcc.animais.category.data.mapper.CategoryMapper
import com.fatec.tcc.animais.category.domain.model.Category
import org.springframework.stereotype.Repository

@Repository
internal class CategoryRepositoryImpl(
    repository: CategoryEntityRepository,
    repositoryMapper: CategoryMapper,
) : DefaultRepository<Category, CategoryEntity>(
    repository,
    repositoryMapper
)