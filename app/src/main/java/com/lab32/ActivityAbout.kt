package com.lab32

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View


class ActivityAbout : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        findViewById<View>(R.id.activity_about_tobrowser_button).setOnClickListener {
            startActivity(
                Intent(
                    this,
                    WebActivity::class.java
                ).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            )
        }
    }
}
