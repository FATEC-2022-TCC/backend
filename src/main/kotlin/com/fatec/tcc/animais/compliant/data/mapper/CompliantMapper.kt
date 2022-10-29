package com.fatec.tcc.animais.compliant.data.mapper

import com.fatec.tcc.animais.base.Mapper
import com.fatec.tcc.animais.base64.data.mapper.Base64Mapper
import com.fatec.tcc.animais.compliant.data.entity.CompliantEntity
import com.fatec.tcc.animais.compliant.domain.model.Compliant
import org.springframework.stereotype.Component

@Component
class CompliantMapper(
    private val base64Mapper: Base64Mapper
) : Mapper<CompliantEntity, Compliant> {
    override fun toEntity(domain: Compliant) = domain.run {
        CompliantEntity(
            id,
            local,
            description,
            created,
            files.map(base64Mapper::toEntity),
            resolution,
            resolutionFiles.map(base64Mapper::toEntity),
            closed,
            updated
        )
    }

    override fun toDomain(entity: CompliantEntity) = entity.run {
        Compliant(
            id,
            local,
            description,
            created,
            files.map(base64Mapper::toDomain),
            resolution,
            resolutionFiles.map(base64Mapper::toDomain),
            closed,
            updated
        )
    }
}