package com.lab32

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lab32.R
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        activity_web_webview.loadUrl("https://www.google.ru")
    }
}
