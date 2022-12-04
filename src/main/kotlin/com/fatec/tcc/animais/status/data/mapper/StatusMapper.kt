package com.fatec.tcc.animais.status.data.mapper

import com.fatec.tcc.animais.base.Mapper
import com.fatec.tcc.animais.base64.data.mapper.Base64Mapper
import com.fatec.tcc.animais.status.data.entity.StatusEntity
import com.fatec.tcc.animais.status.domain.model.Status
import org.springframework.stereotype.Component

@Component
class StatusMapper(
    private val base64Mapper: Base64Mapper
) : Mapper<StatusEntity, Status> {
    override fun toEntity(domain: Status) = domain.run {
        StatusEntity(
            id,
            code,
            description,
            images.map(base64Mapper::toEntity)
        )
    }

    override fun toDomain(entity: StatusEntity) = entity.run {
        Status(
            id,
            code,
            description,
            images.map(base64Mapper::toDomain) as ArrayList,
            created,
            createdBy,
            updated,
            updatedBy
        )
    }
}