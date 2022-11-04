package com.fatec.tcc.animais.complaint.data.entity

import com.fatec.tcc.animais.base.BaseEntity
import com.fatec.tcc.animais.base64.data.entity.Base64Entity
import com.fatec.tcc.animais.status.data.entity.StatusEntity
import javax.persistence.*

@Entity
@Table(name = "complaints")
class ComplaintEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val local: String,
    @Lob
    val description: String,
    @OneToMany(
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    @JoinColumn(name = "complaint_id")
    val files: List<Base64Entity>,
    @OneToMany(
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    @JoinColumn(name = "complaint_id")
    val statuses: List<StatusEntity>,
    val currentStatusCode: Int
) : BaseEntity()