package com.fatec.tcc.animais.content.data.mapper

import com.fatec.tcc.animais.base.Mapper
import com.fatec.tcc.animais.content.data.entity.ContentEntity
import com.fatec.tcc.animais.content.domain.model.Content
import org.springframework.stereotype.Component

@Component
class ContentMapper : Mapper<ContentEntity, Content> {
    override fun toEntity(domain: Content) = domain.run {
        ContentEntity(
            id,
            data,
            background,
            title,
            description,
            until
        )
    }

    override fun toDomain(entity: ContentEntity) = entity.run {
        Content(
            id,
            data,
            background,
            title,
            description,
            until,
            created,
            updated
        )
    }
}