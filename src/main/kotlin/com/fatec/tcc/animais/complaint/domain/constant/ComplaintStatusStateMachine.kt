package com.fatec.tcc.animais.complaint.domain.constant

import com.fatec.tcc.animais.base.StateMachine

object ComplaintStatusStateMachine : StateMachine<ComplaintStatus> {
    private val states = hashMapOf(
        ComplaintStatus.CREATED to setOf(
            ComplaintStatus.RUNNING
        ),
        ComplaintStatus.RUNNING to setOf(
            ComplaintStatus.PAUSED,
            ComplaintStatus.RESOLVED
        ),
        ComplaintStatus.PAUSED to setOf(
            ComplaintStatus.RUNNING
        )
    )

    override fun getAvailableStates(current: ComplaintStatus) =
        states[current] ?: emptySet()

    override fun isStateChangeAllowed(from: ComplaintStatus, to: ComplaintStatus): Boolean {
        return to in (states[from] ?: return false)
    }
}