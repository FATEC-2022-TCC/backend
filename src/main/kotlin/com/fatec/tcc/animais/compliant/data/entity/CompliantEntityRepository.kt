package com.fatec.tcc.animais.compliant.data.entity

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface CompliantEntityRepository : PagingAndSortingRepository<CompliantEntity, Long>