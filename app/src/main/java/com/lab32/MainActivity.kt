package com.lab32

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.bnToSecond).setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.about -> {
                    val intent = Intent(this, ActivityAbout::class.java)
                    this.startActivity(intent)
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }
}

