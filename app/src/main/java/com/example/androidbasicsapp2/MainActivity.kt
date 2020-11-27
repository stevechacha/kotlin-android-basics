package com.example.androidbasicsapp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle:ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    lateinit var NavView: NavigationView
    lateinit var mNext:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_AndroidBasicsApp2)
        setContentView(R.layout.activity_main)

        drawerLayout=findViewById(R.id.drawerlayout)


        toggle=ActionBarDrawerToggle(this,drawerLayout,R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        mNext=findViewById(R.id.next)


        mNext.setOnClickListener {
            val startIntent= Intent(this,NotificationActivity::class.java)
            startActivity(startIntent)
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        NavView=findViewById(R.id.navView)
        NavView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.item1 ->Toast.makeText(applicationContext,"Clicked Item 1",Toast.LENGTH_LONG).show()
                R.id.item2 ->Toast.makeText(applicationContext,"Clicked Item 2",Toast.LENGTH_LONG).show()
                R.id.item3 ->Toast.makeText(applicationContext,"Clicked Item 3",Toast.LENGTH_LONG).show()
            }

            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}