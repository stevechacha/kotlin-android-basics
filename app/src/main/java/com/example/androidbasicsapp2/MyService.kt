package com.example.androidbasicsapp2

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService: Service() {
    val TAG="MyService"
    init {
        Log.d(TAG,"Service is running")
    }
    override fun onBind(intent: Intent?): IBinder? =null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val datastring=intent?.getStringExtra("EXTRA_DATA")
        datastring?.let {
            Log.d(TAG,datastring)
        }
        Thread{
            while (true){ }
        }.start()

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"service is being Killed")
    }
}
