package com.fatec.tcc.animais.complaint.data.repository

import com.fatec.tcc.animais.base.DefaultSearchableRepository
import com.fatec.tcc.animais.complaint.data.entity.ComplaintEntityProjection
import com.fatec.tcc.animais.complaint.data.entity.ComplaintEntityRepository
import com.fatec.tcc.animais.complaint.data.mapper.ComplaintProjectionMapper
import com.fatec.tcc.animais.complaint.domain.model.ComplaintProjection
import com.fatec.tcc.animais.complaint.domain.repository.ComplaintProjectionRepositoryData
import org.springframework.stereotype.Repository

@Repository
class ComplaintProjectionRepositoryImpl(
    complaintEntityRepository: ComplaintEntityRepository,
    complaintProjectionMapper: ComplaintProjectionMapper
) : DefaultSearchableRepository<ComplaintProjection, ComplaintEntityProjection, ComplaintEntityRepository, ComplaintProjectionRepositoryData>(
    repository = complaintEntityRepository,
    projectionMapper = complaintProjectionMapper,
    searchableMapper = { (currentStatusCode, text), pageable -> searchProjection(currentStatusCode, text, pageable) }
)