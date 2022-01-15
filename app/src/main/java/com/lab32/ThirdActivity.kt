package com.lab32

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView



class ThirdActivity : AppCompatActivity() {
    companion object {
        const val TO_FIRST = 1
        const val TO_SECOND = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        findViewById<View>(R.id.bnToFirst).setOnClickListener {
            setResult(TO_FIRST)
            val intent = Intent(this, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            }
            startActivity(intent)
        }

        findViewById<View>(R.id.bnToSecond).setOnClickListener {
            setResult(TO_SECOND)
            finish()
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
