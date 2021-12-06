package com.lab32

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView


class WebActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        val webView = findViewById<WebView>(R.id.activity_web_webview)
        webView.loadUrl("https://www.google.ru")
    }
}
