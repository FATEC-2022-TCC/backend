package com.fatec.tcc.animais.complaint.data.mapper

import com.fatec.tcc.animais.base.Mapper
import com.fatec.tcc.animais.base64.data.mapper.Base64Mapper
import com.fatec.tcc.animais.complaint.data.entity.ComplaintEntity
import com.fatec.tcc.animais.complaint.domain.model.Complaint
import com.fatec.tcc.animais.status.data.mapper.StatusMapper
import org.springframework.stereotype.Component

@Component
class ComplaintMapper(
    private val base64Mapper: Base64Mapper,
    private val statusMapper: StatusMapper
) : Mapper<ComplaintEntity, Complaint> {
    override fun toEntity(domain: Complaint) = domain.run {
        ComplaintEntity(
            id,
            local,
            description,
            images.map(base64Mapper::toEntity),
            statuses.map(statusMapper::toEntity),
            currentStatusCode
        )
    }

    override fun toDomain(entity: ComplaintEntity) = entity.run {
        Complaint(
            id,
            local,
            description,
            images.map(base64Mapper::toDomain),
            statuses.map(statusMapper::toDomain) as ArrayList,
            currentStatusCode,
            created,
            createdBy,
            updated,
            updatedBy
        )
    }
}