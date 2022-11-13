package com.fatec.tcc.animais.adoption.domain.constant

import com.fatec.tcc.animais.base.StateMachine

object AdoptionRequestStatusStateMachine : StateMachine<AdoptionRequestStatusEnum> {
    private val states = hashMapOf(
        AdoptionRequestStatusEnum.REQUESTED to setOf(
            AdoptionRequestStatusEnum.CANCELED
        ),
        AdoptionRequestStatusEnum.ENQUEUED to setOf(
            AdoptionRequestStatusEnum.ADOPTED,
            AdoptionRequestStatusEnum.CANCELED
        ),
        AdoptionRequestStatusEnum.ADOPTED to emptySet(),
        AdoptionRequestStatusEnum.CANCELED to emptySet()
    )

    override fun getAllStates() = AdoptionRequestStatusEnum.values()

    override fun getAvailableStates(current: AdoptionRequestStatusEnum) =
        states[current] ?: emptySet()

    override fun isStateChangeAllowed(from: AdoptionRequestStatusEnum, to: AdoptionRequestStatusEnum): Boolean {
        return to in (states[from] ?: return false)
    }
}