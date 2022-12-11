package com.fatec.tcc.animais.animal.domain.repository

import com.fatec.tcc.animais.animal.domain.model.Animal

interface AnimalRepository {
    fun findByUserIdAndAnimalId(
        userId: Long,
        animalId: Long
    ): Animal?
}