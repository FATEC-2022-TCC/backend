package com.fatec.tcc.animais.base

interface CommonRepository<T> {
    fun all(page: Int): List<T>
    fun insert(type: T): T
    fun find(id: Long): T?
    fun update(user: T): T
}