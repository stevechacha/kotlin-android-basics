package com.example.androidbasicsapp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ServicesActivity : AppCompatActivity() {
    lateinit var BtnStart: Button
    lateinit var BtnStop: Button
    lateinit var BtnSend: Button
    lateinit var mTextView: TextView
    lateinit var mEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services)


        BtnStart=findViewById(R.id.button4)
        BtnStop=findViewById(R.id.button5)
        mTextView=findViewById(R.id.textView1)
        BtnSend=findViewById(R.id.button3)
        mEditText=findViewById(R.id.editText)


        BtnStart.setOnClickListener {
            val intent= Intent(this,MyIntentService::class.java)
            startService(intent)
            mTextView.text="Service Running"
        }

        BtnStop.setOnClickListener {
            val intent= Intent(this,MyIntentService::class.java)
           stopService(intent)
            mTextView.text="Service Stopped"
        }

        BtnSend.setOnClickListener {  val intent= Intent(this,MyIntentService::class.java)
            val datastring=mEditText.text.toString()
            intent.putExtra("EXTRA_DATA",datastring)
            startService(intent)
            mTextView.text="Service Running"


        }




    }
}