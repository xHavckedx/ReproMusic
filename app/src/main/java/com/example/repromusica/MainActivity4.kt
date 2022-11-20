package com.example.repromusica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        var buttonReturn : Button = findViewById(R.id.buttonReturn4)

        buttonReturn.setOnClickListener{
            finish()
        }
    }
}