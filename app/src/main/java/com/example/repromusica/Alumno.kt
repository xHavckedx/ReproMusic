package com.example.repromusica

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Alumno(

    @PrimaryKey(autoGenerate = true)
    val ID: Int,
    val Name: String,
    val Surname: String,
)