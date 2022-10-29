package com.fatec.tcc.animais.compliant.data.mapper

import com.fatec.tcc.animais.base.ProjectionMapper
import com.fatec.tcc.animais.compliant.data.entity.CompliantEntityProjection
import com.fatec.tcc.animais.compliant.domain.model.CompliantProjection
import org.springframework.stereotype.Component

@Component
class CompliantProjectionMapper : ProjectionMapper<CompliantEntityProjection, CompliantProjection> {
    override fun toDomain(entity: CompliantEntityProjection) = entity.run {
        CompliantProjection(
            id,
            local,
            description,
            created,
            closed
        )
    }
}