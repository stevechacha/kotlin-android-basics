package com.example.androidbasicsapp2

import android.app.IntentService
import android.content.Intent
import android.util.Log
import java.lang.Exception

class MyIntentService: IntentService ("My intent services"){
    init {
        instance=this
    }
    companion object{
        private lateinit var instance:MyIntentService
        var isRunning=false

        fun stopService(){
            Log.d("myIntentServices","Service is Stopping")
            isRunning=false
            instance.stopSelf()
        }
    }
    override fun onHandleIntent(intent: Intent?) {

        try {
            isRunning = true
            while (isRunning) {
                Log.d("Myservices", "my service is running")
                Thread.sleep(1000)
            }
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()

        }

    }

}