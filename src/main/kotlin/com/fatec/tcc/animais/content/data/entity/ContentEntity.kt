package com.fatec.tcc.animais.content.data.entity

import com.fatec.tcc.animais.base.BaseEntity
import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "contents")
class ContentEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Lob
    val data: String,
    @Lob
    val background: String,
    @Column(length = 255)
    val title: String,
    val description: String,
    val until: Instant
) : BaseEntity()