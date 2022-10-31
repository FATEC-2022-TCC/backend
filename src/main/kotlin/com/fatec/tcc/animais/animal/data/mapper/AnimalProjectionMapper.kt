package com.fatec.tcc.animais.animal.data.mapper

import com.fatec.tcc.animais.animal.data.entity.AnimalEntityProjection
import com.fatec.tcc.animais.animal.domain.model.AnimalProjection
import com.fatec.tcc.animais.base.ProjectionMapper
import org.springframework.stereotype.Component

@Component
class AnimalProjectionMapper : ProjectionMapper<AnimalEntityProjection, AnimalProjection> {
    override fun toDomain(entity: AnimalEntityProjection) = entity.run {
        AnimalProjection(
            id,
            picture,
            name,
            specie
        )
    }
}