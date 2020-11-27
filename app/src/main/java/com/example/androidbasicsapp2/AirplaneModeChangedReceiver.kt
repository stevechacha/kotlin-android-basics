package com.example.androidbasicsapp2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeChangedReceiver:BroadcastReceiver (){
    override fun onReceive(context: Context?, intent: Intent?) {
       val isAirplaneModeEnabled=intent?.getBooleanExtra("state",false) ?:return
        if (isAirplaneModeEnabled){
            Toast.makeText(context,"Airplane mode enabled",Toast.LENGTH_LONG).show()
        } else{
            Toast.makeText(context,"Airplane mode disabled",Toast.LENGTH_LONG).show()

        }
    }

}