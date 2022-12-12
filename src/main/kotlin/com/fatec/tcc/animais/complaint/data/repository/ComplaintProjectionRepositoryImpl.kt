package com.fatec.tcc.animais.complaint.data.repository

import com.fatec.tcc.animais.base.DefaultSearchableRepository
import com.fatec.tcc.animais.complaint.data.entity.ComplaintEntityProjection
import com.fatec.tcc.animais.complaint.data.entity.ComplaintEntityRepository
import com.fatec.tcc.animais.complaint.data.mapper.ComplaintProjectionMapper
import com.fatec.tcc.animais.complaint.domain.model.ComplaintProjection
import com.fatec.tcc.animais.complaint.domain.repository.ComplaintProjectionRepositoryData
import com.fatec.tcc.animais.complaint.domain.repository.ComplaintRepository
import org.springframework.stereotype.Repository

@Repository
internal class ComplaintProjectionRepositoryImpl(
    private val repository: ComplaintEntityRepository,
    private val  repositoryMapper: ComplaintProjectionMapper
) : DefaultSearchableRepository<ComplaintProjection, ComplaintEntityProjection, ComplaintEntityRepository, ComplaintProjectionRepositoryData>(
    repository = repository,
    projectionMapper = repositoryMapper,
    searchableMapper = { (currentStatusCode, text), pageable -> search(currentStatusCode, text, pageable) }
), ComplaintRepository {
    override fun search(
        statuses: List<Int>
    ) = repository.search(statuses).map(repositoryMapper::toDomain)
}