package com.fatec.tcc.animais.content.data.mapper

import com.fatec.tcc.animais.base.ProjectionMapper
import com.fatec.tcc.animais.content.data.entity.ContentProjectionEntity
import com.fatec.tcc.animais.content.domain.model.ContentProjection
import org.springframework.stereotype.Component

@Component
class ContentProjectionMapper : ProjectionMapper<ContentProjectionEntity, ContentProjection> {
    override fun toDomain(entity: ContentProjectionEntity) = entity.run {
        ContentProjection(
            id,
            title,
            description,
            background
        )
    }
}