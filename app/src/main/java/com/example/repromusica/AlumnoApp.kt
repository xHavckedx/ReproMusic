package com.example.repromusica

import android.app.Application
import androidx.room.Room

class AlumnoApp : Application() {
    val room = Room.databaseBuilder(this, DBTest::class.java, "Alumno").build()
}