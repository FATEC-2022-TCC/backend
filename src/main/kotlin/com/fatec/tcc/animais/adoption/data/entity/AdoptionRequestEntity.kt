package com.fatec.tcc.animais.adoption.data.entity

import com.fatec.tcc.animais.base.BaseEntity
import com.fatec.tcc.animais.status.data.entity.StatusEntity
import javax.persistence.*

@Entity
@Table(name = "adoption_requests")
class AdoptionRequestEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @OneToMany(
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    @JoinColumn(name = "adoption_request_id")
    val statuses: List<StatusEntity>,
    val currentStatusCode: Int,
) : BaseEntity()