package com.fatec.tcc.animais.adoption.domain.constant

import com.fatec.tcc.animais.base.StateMachine

object AdoptionStatusStateMachine : StateMachine<AdoptionStatusEnum> {
    private val states = hashMapOf(
        AdoptionStatusEnum.CREATED to setOf(
            AdoptionStatusEnum.VISIBLE,
            AdoptionStatusEnum.INVISIBLE,
            AdoptionStatusEnum.ADOPTED
        ),
        AdoptionStatusEnum.VISIBLE to setOf(
            AdoptionStatusEnum.INVISIBLE,
            AdoptionStatusEnum.ADOPTED,
            AdoptionStatusEnum.IMPOSSIBLE,
        ),
        AdoptionStatusEnum.INVISIBLE to setOf(
            AdoptionStatusEnum.VISIBLE,
            AdoptionStatusEnum.ADOPTED,
            AdoptionStatusEnum.IMPOSSIBLE,
        ),
        AdoptionStatusEnum.ADOPTED to emptySet(),
        AdoptionStatusEnum.IMPOSSIBLE to emptySet()
    )

    override fun getAllStates() = AdoptionStatusEnum.values()

    override fun getAvailableStates(current: AdoptionStatusEnum) =
        states[current] ?: emptySet()

    override fun isStateChangeAllowed(from: AdoptionStatusEnum, to: AdoptionStatusEnum): Boolean {
        return to in (states[from] ?: return false)
    }
}