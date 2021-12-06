package com.lab32

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView


class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        findViewById<View>(R.id.bnToFirst).setOnClickListener {
            finish()
        }
        findViewById<View>(R.id.bnToThird).setOnClickListener {
            startActivity(Intent(this, ThirdActivity::class.java))
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
   /*
   //Решение 1

   override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
       super.onActivityResult(requestCode, resultCode, data)
       if (requestCode == 1) {
           if (resultCode == ThirdActivity.TO_FIRST) {
               finish()
           }
       }
    }

   */
}
