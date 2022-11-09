package com.fatec.tcc.animais.adoption.data.entity

import com.fatec.tcc.animais.base.BaseEntity
import com.fatec.tcc.animais.base64.data.entity.Base64Entity
import com.fatec.tcc.animais.status.data.entity.StatusEntity
import javax.persistence.*

@Entity
@Table(name = "adoptions")
class AdoptionEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    @OneToMany(
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    @JoinColumn(name = "adoption_id")
    val files: List<Base64Entity>,
    @OneToMany(
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    @JoinColumn(name = "adoption_id")
    val statuses: List<StatusEntity>,
    val currentStatusCode: Int,
    @OneToMany(
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    @JoinColumn(name = "adoption_id")
    val requests: List<AdoptionRequestEntity>
) : BaseEntity()