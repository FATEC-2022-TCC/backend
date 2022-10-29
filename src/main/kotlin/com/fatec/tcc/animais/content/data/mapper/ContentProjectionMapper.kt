package com.fatec.tcc.animais.content.data.mapper

import com.fatec.tcc.animais.base.ProjectionMapper
import com.fatec.tcc.animais.content.data.entity.ContentEntityProjection
import com.fatec.tcc.animais.content.domain.model.ContentProjection
import org.springframework.stereotype.Component

@Component
class ContentProjectionMapper : ProjectionMapper<ContentEntityProjection, ContentProjection> {
    override fun toDomain(entity: ContentEntityProjection) = entity.run {
        ContentProjection(
            id,
            title,
            description,
            background
        )
    }
}