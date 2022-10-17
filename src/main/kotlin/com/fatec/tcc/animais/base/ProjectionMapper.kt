package com.fatec.tcc.animais.base

interface ProjectionMapper<Entity, Domain> {
    fun toDomain(entity: Entity): Domain
}