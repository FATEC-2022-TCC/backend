package com.fatec.tcc.animais.adoption.data.mapper

import com.fatec.tcc.animais.adoption.data.entity.AdoptionRequestEntityProjection
import com.fatec.tcc.animais.adoption.domain.model.AdoptionRequestProjection
import com.fatec.tcc.animais.base.ProjectionMapper
import org.springframework.stereotype.Component

@Component
class AdoptionRequestProjectionMapper : ProjectionMapper<AdoptionRequestEntityProjection, AdoptionRequestProjection> {
    override fun toDomain(entity: AdoptionRequestEntityProjection) = entity.run {
        AdoptionRequestProjection(
            id,
            currentStatusCode,
            createdBy
        )
    }
}