package com.lab32

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_third.*


class ThirdActivity : AppCompatActivity() {
    companion object {
        const val TO_FIRST = 1
        const val TO_SECOND = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        activity_third_tofirst_button.setOnClickListener {
            //Решение 1
            //setResult(TO_FIRST)
            val intent = Intent(this, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            }
            startActivity(intent)
        }

        activity_third_tosecond_button.setOnClickListener {
            //Решение 1
            //setResult(TO_SECOND)
            finish()
        }
        val bottomNavView = findViewById<BottomNavigationView>(R.id.activity_third_bottom_nav)
        bottomNavView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.about -> {
                    startActivity(Intent(this, AboutActivity::class.java))
                }
            }
            true
        }

    }
}
