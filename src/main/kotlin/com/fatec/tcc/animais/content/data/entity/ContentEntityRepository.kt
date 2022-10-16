package com.fatec.tcc.animais.content.data.entity

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ContentEntityRepository : JpaRepository<ContentEntity, Long>