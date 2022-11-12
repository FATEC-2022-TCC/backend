package com.fatec.tcc.animais.category.data.mapper

import com.fatec.tcc.animais.base.Mapper
import com.fatec.tcc.animais.base64.data.mapper.Base64Mapper
import com.fatec.tcc.animais.base64.domain.model.Base64
import com.fatec.tcc.animais.category.data.entity.CategoryEntity
import com.fatec.tcc.animais.category.domain.model.Category
import org.springframework.stereotype.Component

@Component
class CategoryMapper(
    private val base64Mapper: Base64Mapper
) : Mapper<CategoryEntity, Category> {
    override fun toEntity(domain: Category) = domain.run {
        CategoryEntity(
            id,
            name,
            description,
            images.map(base64Mapper::toEntity),
            files.map(base64Mapper::toEntity)
        )
    }

    override fun toDomain(entity: CategoryEntity) = entity.run {
        Category(
            id,
            name,
            description,
            images.map(base64Mapper::toDomain) as ArrayList,
            files.map(base64Mapper::toDomain) as ArrayList
        )
    }
}