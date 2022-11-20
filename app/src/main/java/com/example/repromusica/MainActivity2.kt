package com.example.repromusica

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.coroutines.launch

class MainActivity2 : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val buttonCreateTable : Button = findViewById(R.id.buttonCreateTable)
        val buttonDataInsert : Button = findViewById(R.id.buttonDataInsert)
        val buttonQueryData : Button = findViewById(R.id.buttonQueryData)
        val buttonReturn: Button = findViewById(R.id.buttonReturn2)

        val editTextID: EditText = findViewById(R.id.editTextID)
        val editTextName: EditText = findViewById(R.id.editTextName)
        val editTextSurname: EditText = findViewById(R.id.editTextSurname)
        //val room by lazy {applicationContext as AlumnoApp}
        val room = Room.databaseBuilder(this, DBTest::class.java, "Alumno").allowMainThreadQueries().build()

        buttonDataInsert.setOnClickListener{
            val alumnos = room.daoAlumno().getAll()
            var alumnoSelected = editTextID.text.toString().toInt()
            var cont = 0
            for(allAlumnos in alumnos){
                if(alumnoSelected == allAlumnos.ID){
                    cont++
                }
            }
            if(cont < 1){
                room.daoAlumno().addAlumno(Alumno(editTextID.text.toString().toInt(),
                                                editTextName.text.toString(),
                                                editTextSurname.text.toString()))
            }else{
                Toast.makeText(this,"Error el id, ya existe", Toast.LENGTH_LONG).show()
            }

        }

        buttonQueryData.setOnClickListener{
            val alumnos = room.daoAlumno().getAll()
            var alumnoSelected = editTextID.text.toString().toInt()
            var cont = 0
            for(allAlumnos in alumnos){
                if(alumnoSelected == allAlumnos.ID){
                    cont++
                }
            }
            if(cont != 0){
                var alumno = room.daoAlumno().getAlumnoById(editTextID.text.toString().toInt())
                editTextName.setText(alumno.Name)
                editTextSurname.setText(alumno.Surname)
            } else{
                Toast.makeText(this,"Error el id, no existe", Toast.LENGTH_LONG).show()
            }
        }

        buttonCreateTable.setOnClickListener{
            Toast.makeText(this,"Base de datos creada con exito", Toast.LENGTH_SHORT).show()
        }

        buttonReturn.setOnClickListener{
            finish()
        }
    }
}