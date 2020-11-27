package com.example.androidbasicsapp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class IntentServiceActivity : AppCompatActivity() {
    lateinit var BtnStart: Button
    lateinit var BtnStop: Button
    lateinit var mTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_service)

        BtnStart=findViewById(R.id.button)
        BtnStop=findViewById(R.id.button2)
        mTextView=findViewById(R.id.textView)

        mTextView.setOnClickListener {
            val intent= Intent(this,ServicesActivity::class.java)
            startActivity(intent)
        }

        BtnStart.setOnClickListener {
            val Intent=Intent(this,MyIntentService::class.java)
            startService(Intent)
            mTextView.text="Service Running"
        }

        BtnStop.setOnClickListener {
            MyIntentService.stopService()
            mTextView.text="Service Stopped"
        }

    }


}