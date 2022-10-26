package com.fatec.tcc.animais.compliant.data.entity

import com.fatec.tcc.animais.base64.data.entity.Base64Entity
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "compliants")
class CompliantEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val local: String,
    val description: String,
    val created: Date,
    @OneToMany(
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    @JoinColumn(name = "compliant_id")
    val files: List<Base64Entity>
)