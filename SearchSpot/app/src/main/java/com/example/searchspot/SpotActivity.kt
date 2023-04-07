//package com.example.searchspot
//
//import android.os.Bundle
//import android.webkit.WebChromeClient
//import androidx.appcompat.app.AppCompatActivity
//
//class SpotActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_spot)
//
//        val url = intent.getStringExtra("https://dev.urbanaut.in/api/v1.4/spot/approved/?city=Bengaluru&format=json")
//
//        webView.settings.javaScriptEnabled = true
//        webView.webChromeClient = WebChromeClient()
//        webView.loadUrl(url)
//    }
//}