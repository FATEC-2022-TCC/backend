package com.fatec.tcc.animais.base

interface StateMachine<T> {
    fun getAllStates(): Array<T>
    fun getAvailableStates(current: T): Set<T>
    fun isStateChangeAllowed(from: T, to: T): Boolean
}