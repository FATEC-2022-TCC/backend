package com.fatec.tcc.animais.animal.data

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AnimalEntityRepository : JpaRepository<AnimalEntity, Long>