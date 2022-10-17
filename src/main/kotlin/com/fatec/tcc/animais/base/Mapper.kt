package com.fatec.tcc.animais.base

interface Mapper<Entity, Domain> : ProjectionMapper<Entity, Domain> {
    fun toEntity(domain: Domain): Entity
}