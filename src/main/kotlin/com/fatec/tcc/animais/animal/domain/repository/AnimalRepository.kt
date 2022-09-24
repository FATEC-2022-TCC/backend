package com.fatec.tcc.animais.animal.domain.repository

import com.fatec.tcc.animais.animal.domain.model.Animal

interface AnimalRepository {
    fun all(): List<Animal>
    fun insert(animal: Animal): Animal
    fun find(id: Long): Animal?
    fun find(name: String): Animal?
    fun update(animal: Animal): Animal
}