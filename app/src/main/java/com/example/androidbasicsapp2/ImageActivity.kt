package com.example.androidbasicsapp2

import android.content.Context
import android.content.Intent
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract

class ImageActivity : AppCompatActivity() {

    private val cropActivityResultContract=object :ActivityResultContract<Any?, Uri?>(){
        override fun createIntent(context: Context, input: Any?): Intent {

            return Image()


        }

        override fun parseResult(resultCode: Int, intent: Intent?): Uri? {


        }

    }

    private lateinit var cropActivityResultLauncher:ActivityResultLauncher<Any?>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)


        val imageView=findViewById<ImageView>(R.id.imageView)
        val chooseImageBtn =findViewById<Button>(R.id.chooseImage)
        cropActivityResultLauncher=registerForActivityResult(cropActivityResultContract){
            it?.let {
                imageView.setImageURI(uri)
            }
        }
        chooseImageBtn.setOnClickListener {
            cropActivityResultLauncher.launch(null)
        }
    }
}