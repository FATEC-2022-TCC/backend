package com.fatec.tcc.animais.compliant.data.mapper

import com.fatec.tcc.animais.base.Mapper
import com.fatec.tcc.animais.base64.data.mapper.Base64Mapper
import com.fatec.tcc.animais.compliant.data.entity.CompliantEntity
import com.fatec.tcc.animais.compliant.domain.model.Compliant
import com.fatec.tcc.animais.status.data.mapper.StatusMapper
import org.springframework.stereotype.Component

@Component
class CompliantMapper(
    private val base64Mapper: Base64Mapper,
    private val statusMapper: StatusMapper
) : Mapper<CompliantEntity, Compliant> {
    override fun toEntity(domain: Compliant) = domain.run {
        CompliantEntity(
            id,
            local,
            description,
            files.map(base64Mapper::toEntity),
            created,
            updated,
            statuses.map(statusMapper::toEntity)
        )
    }

    override fun toDomain(entity: CompliantEntity) = entity.run {
        Compliant(
            id,
            local,
            description,
            files.map(base64Mapper::toDomain),
            created,
            updated,
            statuses.map(statusMapper::toDomain) as ArrayList
        )
    }
}