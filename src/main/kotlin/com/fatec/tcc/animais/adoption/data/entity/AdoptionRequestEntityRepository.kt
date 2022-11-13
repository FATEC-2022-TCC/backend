package com.fatec.tcc.animais.adoption.data.entity

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AdoptionRequestEntityRepository : JpaRepository<AdoptionRequestEntity, Long>