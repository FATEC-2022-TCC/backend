package com.fatec.tcc.animais.base64.data.entity

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface Base64EntityRepository : PagingAndSortingRepository<Base64Entity, Long>