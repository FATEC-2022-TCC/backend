package com.fatec.tcc.animais.base

interface Mapper<Entity, Domain> {
    fun toEntity(domain: Domain): Entity
    fun toDomain(entity: Entity): Domain
}