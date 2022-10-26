package com.fatec.tcc.animais.compliant.data.mapper

import com.fatec.tcc.animais.base.ProjectionMapper
import com.fatec.tcc.animais.compliant.data.entity.CompliantProjectionEntity
import com.fatec.tcc.animais.compliant.domain.model.CompliantProjection
import org.springframework.stereotype.Component

@Component
class CompliantProjectionMapper : ProjectionMapper<CompliantProjectionEntity, CompliantProjection> {
    override fun toDomain(entity: CompliantProjectionEntity) = entity.run {
        CompliantProjection(
            id,
            local,
            description,
            created
        )
    }
}