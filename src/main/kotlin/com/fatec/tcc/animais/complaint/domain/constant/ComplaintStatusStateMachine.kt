package com.fatec.tcc.animais.complaint.domain.constant

import com.fatec.tcc.animais.base.StateMachine

object ComplaintStatusStateMachine : StateMachine<ComplaintStatusEnum> {
    private val states = hashMapOf(
        ComplaintStatusEnum.CREATED to setOf(
            ComplaintStatusEnum.RUNNING,
            ComplaintStatusEnum.CANCEL
        ),
        ComplaintStatusEnum.RUNNING to setOf(
            ComplaintStatusEnum.PAUSED,
            ComplaintStatusEnum.RESOLVED,
            ComplaintStatusEnum.CANCEL
        ),
        ComplaintStatusEnum.PAUSED to setOf(
            ComplaintStatusEnum.RUNNING,
            ComplaintStatusEnum.CANCEL
        ),
        ComplaintStatusEnum.RESOLVED to emptySet(),
        ComplaintStatusEnum.CANCEL to emptySet()
    )

    override fun getAllStates() = ComplaintStatusEnum.values()

    override fun getAvailableStates(current: ComplaintStatusEnum) =
        states[current] ?: emptySet()

    override fun isStateChangeAllowed(from: ComplaintStatusEnum, to: ComplaintStatusEnum): Boolean {
        return to in (states[from] ?: return false)
    }
}