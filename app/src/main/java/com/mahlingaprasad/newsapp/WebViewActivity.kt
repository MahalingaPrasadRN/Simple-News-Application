package com.mahlingaprasad.newsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.ImageView
import android.widget.Toast

class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        supportActionBar?.hide()

        val webView = findViewById<WebView>(R.id.webView)
        val back = findViewById<ImageView>(R.id.back)
        webView.settings.setJavaScriptEnabled(true)
        intent.getStringExtra("url")?.let { webView.loadUrl(it) }

        back.setOnClickListener(View.OnClickListener { v-> goHome() })
    }

    private fun goHome(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}