package com.example.repromusica

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //referenciamos objetos
        val buttonActivity2 : Button = findViewById(R.id.buttonActivity2)
        val buttonActivity3 : Button = findViewById(R.id.buttonActivity3)
        val buttonActivity4 : Button = findViewById(R.id.buttonActivity4)
        val buttonPlay : Button = findViewById(R.id.buttonPlay)
        val buttonPause : Button = findViewById(R.id.buttonPause)
        val buttonStop : Button = findViewById(R.id.buttonStop)
        var mediaPlayer = MediaPlayer.create(this, R.raw.vivaldi)

        buttonActivity2.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        buttonActivity3.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }

        buttonActivity4.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java)
            startActivity(intent)
        }

        buttonPlay.setOnClickListener{
            mediaPlayer.start()
            Toast.makeText(this,"Reproduciendo", Toast.LENGTH_LONG).show()
        }

        buttonPause.setOnClickListener{
            mediaPlayer.pause()
            Toast.makeText(this,"Pausado", Toast.LENGTH_LONG).show()
        }

        buttonStop.setOnClickListener{
            mediaPlayer.stop()
            Toast.makeText(this,"Parado", Toast.LENGTH_LONG).show()
            mediaPlayer = MediaPlayer.create(this, R.raw.vivaldi)
        }
    }

}