package com.fatec.tcc.animais.status.data.entity

import com.fatec.tcc.animais.base.BaseEntity
import com.fatec.tcc.animais.base64.data.entity.Base64Entity
import javax.persistence.*

@Entity
@Table(name = "statuses")
class StatusEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val code: Int,
    @Lob
    val description: String,
    @OneToMany(
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    @JoinColumn(name = "status_id")
    val files: List<Base64Entity>,
) : BaseEntity()