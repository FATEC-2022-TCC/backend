package com.fatec.tcc.animais.animal.data.entity

import java.util.Date
import javax.persistence.*

@Entity
@Table(name = "animals")
class AnimalEntity(
    @Id
    @GeneratedValue
    val id: Long,
    val name: String,
    val description: String,
    val type: String,
    val birth: Date,
    val picture_name:String,
    @Lob
    @Column(name="animal_picture")
    var animalPicture: ByteArray
)