package com.fatec.tcc.animais.complaint.data.mapper

import com.fatec.tcc.animais.base.ProjectionMapper
import com.fatec.tcc.animais.complaint.data.entity.ComplaintEntityProjection
import com.fatec.tcc.animais.complaint.domain.model.ComplaintProjection
import org.springframework.stereotype.Component

@Component
class ComplaintProjectionMapper : ProjectionMapper<ComplaintEntityProjection, ComplaintProjection> {
    override fun toDomain(entity: ComplaintEntityProjection) = entity.run {
        ComplaintProjection(
            id,
            local,
            description,
            created
        )
    }
}