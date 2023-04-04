package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {

    private lateinit var mAdapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        mAdapter = NewsAdapter()
        recyclerView.adapter = mAdapter

        fun fetchNews() {
            val queue = Volley.newRequestQueue(this)
            val url = "https://saurav.tech/NewsAPI/top-headlines/category/health/in.json"
            val jsonObjectRequest = JsonObjectRequest(
                Request.Method.GET, url, null,
                Response.Listener {
                    val newsJsonArray = it.getJSONArray("articles")
                    val newsArray = ArrayList<News>()
                   for (i in 0 until newsJsonArray.length()){
                       val newsJsonObject = newsJsonArray.getJSONObject(i)
                       val news = News(
                           newsJsonObject.getString("title"),
                           newsJsonObject.getString("author"),
                           newsJsonObject.getString("url"),
                           newsJsonObject.getString("utlToImage")
                       )
                       newsArray.add(news)
                   }
                    mAdapter.updateData(newsArray)

                },
                Response.ErrorListener {

                }

            )
        }
    }
}