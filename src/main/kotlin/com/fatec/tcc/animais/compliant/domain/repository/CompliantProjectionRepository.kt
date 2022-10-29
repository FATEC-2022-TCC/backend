package com.fatec.tcc.animais.compliant.domain.repository

import com.fatec.tcc.animais.base.SearchableRepository
import com.fatec.tcc.animais.compliant.domain.model.CompliantProjection

interface CompliantProjectionRepository :
    SearchableRepository<CompliantProjection, CompliantProjectionRepositoryData>