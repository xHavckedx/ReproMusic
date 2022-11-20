package com.example.repromusica

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import java.io.File
import java.util.jar.Manifest

class MainActivity3 : AppCompatActivity() {
    private val REQUEST_CODE_CAMERA : Int = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val buttonPicture : Button = findViewById(R.id.buttonPicture)
        val buttonReturn : Button = findViewById(R.id.buttonReturn)

        buttonPicture.setOnClickListener{
            val pictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if(pictureIntent.resolveActivity(packageManager) != null){
            startActivityForResult(pictureIntent, REQUEST_CODE_CAMERA)
            }
        }
        buttonReturn.setOnClickListener{
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE_CAMERA && resultCode == RESULT_OK){
            val imageView : ImageView = findViewById(R.id.imageView3)
            val bitmap = data?.extras?.get("data") as Bitmap
            imageView.setImageBitmap(bitmap)
        }
    }
}