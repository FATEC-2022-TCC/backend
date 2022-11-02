package com.fatec.tcc.animais.complaint.data.repository

import com.fatec.tcc.animais.base.DefaultRepository
import com.fatec.tcc.animais.complaint.data.entity.ComplaintEntity
import com.fatec.tcc.animais.complaint.data.entity.ComplaintEntityRepository
import com.fatec.tcc.animais.complaint.data.mapper.ComplaintMapper
import com.fatec.tcc.animais.complaint.domain.model.Complaint
import org.springframework.stereotype.Repository

@Repository
class ComplaintRepositoryImpl(
    contentEntityRepository: ComplaintEntityRepository,
    complaintMapper: ComplaintMapper
) : DefaultRepository<Complaint, ComplaintEntity, ComplaintEntityRepository>(
    repository = contentEntityRepository,
    repositoryMapper = complaintMapper
)