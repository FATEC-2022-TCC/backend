package com.fatec.tcc.animais.content.data.entity

import java.util.Date
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
    val created: Date,
    val until: Date
)