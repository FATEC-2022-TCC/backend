package com.fatec.tcc.animais.base

interface CommonRepository<T> {
    fun all(): List<T> = TODO("Must be implemented")
    fun insert(type: T): T = TODO("Must be implemented")
    fun find(id: Long): T? = TODO("Must be implemented")
    fun update(type: T): T = TODO("Must be implemented")
    fun delete(id: Long): Unit = TODO("Must be implemented")
}