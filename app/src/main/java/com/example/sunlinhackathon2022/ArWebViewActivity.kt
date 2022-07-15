package com.example.sunlinhackathon2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class ArWebViewActivity : AppCompatActivity() {
    lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ar_web_view)

        webView = findViewById<WebView>(R.id.webView)

        webView.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
        }
        val webARUrl = intent.getStringExtra("arUrl")
        webView.loadUrl(webARUrl!!)

    }
}