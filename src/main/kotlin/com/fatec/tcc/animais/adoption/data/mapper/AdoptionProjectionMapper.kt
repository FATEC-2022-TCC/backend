package com.fatec.tcc.animais.adoption.data.mapper

import com.fatec.tcc.animais.adoption.data.entity.AdoptionEntityProjection
import com.fatec.tcc.animais.adoption.domain.model.AdoptionProjection
import com.fatec.tcc.animais.base.ProjectionMapper
import org.springframework.stereotype.Component

@Component
class AdoptionProjectionMapper : ProjectionMapper<AdoptionEntityProjection, AdoptionProjection> {
    override fun toDomain(entity: AdoptionEntityProjection) = entity.run {
        AdoptionProjection(
            id,
            name,
            description,
            picture
        )
    }
}