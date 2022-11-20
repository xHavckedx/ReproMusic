package com.example.repromusica

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface DaoAlumno  {

    @Query("SELECT * FROM Alumno")
    fun getAll(): List<Alumno>

    @Query("SELECT * FROM Alumno WHERE ID=:ID")
    fun getAlumnoById(ID: Int): Alumno

    @Insert
    fun addAlumno(alumno: Alumno)

    @Update
    fun updateAlumno(alumno : Alumno)

    @Query("Delete from Alumno Where ID=:ID")
    fun removeAlumno(ID:Int)
}