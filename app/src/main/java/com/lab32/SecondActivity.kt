package com.lab32

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        activity_second_tofirst_button.setOnClickListener {
            finish()
        }

        activity_second_tothird_button.setOnClickListener {
            startActivity(Intent(this, ThirdActivity::class.java))
       }


        val bottomNavView = findViewById<BottomNavigationView>(R.id.activity_second_bottom_nav)
        bottomNavView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.about -> {
                    startActivity(Intent(this, AboutActivity::class.java))
                }
            }
            true
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
