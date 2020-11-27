package com.example.androidbasicsapp2

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class NotificationActivity : AppCompatActivity() {
    val CHANNEL_ID="channelID"
    val CHANNEL_NAME="channelName"
    val NOTIFICATION_ID=0

    lateinit var mNotify:Button
    lateinit var mNoty:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        createNotificationChannel()

        val intent= Intent(this,NotificationActivity::class.java)
        val pendingIntent=TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT)
        }

        mNotify=findViewById(R.id.buttonNotify)
        mNoty=findViewById(R.id.nextt)
        mNoty.setOnClickListener {
            val intent= Intent(this,IntentServiceActivity::class.java)
            startActivity(intent)

        }

        val notification=NotificationCompat.Builder(this,CHANNEL_ID)
                .setContentTitle("Awesome notification")
                .setContentText("notifcation text")
                .setSmallIcon(R.drawable.ic_notification_foreground)
               .setPriority(NotificationCompat.PRIORITY_HIGH)
               .setContentIntent(pendingIntent)
               .build()

        val notificationManager=NotificationManagerCompat.from(this)

        mNotify.setOnClickListener {
            notificationManager.notify(NOTIFICATION_ID,notification)
        }
    }

    fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val channel=NotificationChannel(CHANNEL_ID,CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_DEFAULT).apply {
                        lightColor=Color.GREEN
                enableLights(true)
            }

            val manager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }

    }
}