package com.fatec.tcc.animais.reality.data.entity

import com.fatec.tcc.animais.base.BaseEntity
import com.fatec.tcc.animais.base64.data.entity.Base64Entity
import javax.persistence.*

@Entity
@Table(name = "realities")
class RealityEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Lob
    val data: String,
    val scale: Float,
    val title: String,
    val description: String,
    val background: String,
    val isVisible: Boolean,
    @OneToMany(
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    @JoinColumn(name = "reality_id")
    val images: List<Base64Entity>
) : BaseEntity()