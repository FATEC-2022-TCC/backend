package com.fatec.tcc.animais.compliant.data.repository

import com.fatec.tcc.animais.compliant.data.entity.CompliantEntityRepository
import com.fatec.tcc.animais.compliant.data.mapper.CompliantProjectionMapper
import com.fatec.tcc.animais.compliant.domain.repository.CompliantProjectionRepository
import org.springframework.stereotype.Repository

@Repository
class CompliantProjectionRepositoryImpl(
    private val compliantEntityRepository: CompliantEntityRepository,
    private val compliantProjectionMapper: CompliantProjectionMapper
) : CompliantProjectionRepository