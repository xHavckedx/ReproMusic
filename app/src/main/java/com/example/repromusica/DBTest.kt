package com.example.repromusica

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Alumno::class],
    version = 1
)
abstract class DBTest: RoomDatabase(){
    abstract fun daoAlumno():DaoAlumno
}