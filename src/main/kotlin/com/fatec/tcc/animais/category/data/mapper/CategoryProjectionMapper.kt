package com.fatec.tcc.animais.category.data.mapper

import com.fatec.tcc.animais.base.ProjectionMapper
import com.fatec.tcc.animais.category.data.entity.CategoryEntityProjection
import com.fatec.tcc.animais.category.domain.model.CategoryProjection
import org.springframework.stereotype.Component

@Component
class CategoryProjectionMapper : ProjectionMapper<CategoryEntityProjection, CategoryProjection> {
    override fun toDomain(entity: CategoryEntityProjection) = entity.run {
        CategoryProjection(
            id,
            name,
            description
        )
    }
}