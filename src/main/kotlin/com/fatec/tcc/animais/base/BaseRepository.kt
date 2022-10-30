package com.fatec.tcc.animais.base

interface BaseRepository<T> {
    fun all(): List<T>
    fun insert(type: T): T
    fun find(id: Long): T?
    fun update(type: T): T
    fun delete(id: Long)
}