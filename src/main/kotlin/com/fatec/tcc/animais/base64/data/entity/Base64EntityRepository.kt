package com.fatec.tcc.animais.base64.data.entity

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface Base64EntityRepository : JpaRepository<Base64Entity, Long>