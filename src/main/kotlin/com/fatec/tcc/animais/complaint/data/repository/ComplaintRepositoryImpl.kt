package com.fatec.tcc.animais.complaint.data.repository

import com.fatec.tcc.animais.base.DefaultRepository
import com.fatec.tcc.animais.complaint.data.entity.ComplaintEntity
import com.fatec.tcc.animais.complaint.data.entity.ComplaintEntityRepository
import com.fatec.tcc.animais.complaint.data.mapper.ComplaintMapper
import com.fatec.tcc.animais.complaint.domain.model.Complaint
import org.springframework.stereotype.Repository

@Repository
internal class ComplaintRepositoryImpl(
    repository: ComplaintEntityRepository,
    repositoryMapper: ComplaintMapper
) : DefaultRepository<Complaint, ComplaintEntity>(
    repository,
    repositoryMapper
)