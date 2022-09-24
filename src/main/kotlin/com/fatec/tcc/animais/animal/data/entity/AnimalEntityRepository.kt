package com.fatec.tcc.animais.animal.data.entity

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AnimalEntityRepository : JpaRepository<AnimalEntity, Long>{
    fun findByName(name: String): AnimalEntity?
}