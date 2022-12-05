package com.fatec.tcc.animais.reality.data.mapper

import com.fatec.tcc.animais.base.ProjectionMapper
import com.fatec.tcc.animais.reality.data.entity.RealityEntityProjection
import com.fatec.tcc.animais.reality.domain.model.RealityProjection

class RealityProjectionMapper : ProjectionMapper<RealityEntityProjection, RealityProjection> {
    override fun toDomain(entity: RealityEntityProjection) = entity.run {
        RealityProjection(
            id,
            title,
            background,
            isVisible
        )
    }
}