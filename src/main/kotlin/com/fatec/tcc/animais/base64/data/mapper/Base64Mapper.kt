package com.fatec.tcc.animais.base64.data.mapper

import com.fatec.tcc.animais.base.Mapper
import com.fatec.tcc.animais.base64.data.entity.Base64Entity
import com.fatec.tcc.animais.base64.domain.model.Base64
import org.springframework.stereotype.Component

@Component
class Base64Mapper : Mapper<Base64Entity, Base64> {
    override fun toEntity(domain: Base64) = domain.run {
        Base64Entity(
            id,
            data
        )
    }

    override fun toDomain(entity: Base64Entity) = entity.run {
        Base64(
            id,
            data,
            created,
            createdBy,
            updated,
            updatedBy
        )
    }
}