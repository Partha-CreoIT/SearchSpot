package com.example.newsapp
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request

import com.android.volley.toolbox.JsonObjectRequest

class MainActivity : AppCompatActivity(), OnItemClicked {

    private lateinit var mAdaptor: NewsListAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView:RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchData()
        mAdaptor = NewsListAdaptor(this)
        recyclerView.adapter = mAdaptor

    }

    private fun fetchData(){
        val url = "https://saurav.tech/NewsAPI/top-headlines/category/health/in.json"
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,url,null,
            {
                val newsJsonArray = it.getJSONArray("articles")
                val newsArray = ArrayList<News>()
                for(i in 0 until newsJsonArray.length()){
                    val newsJsonObject = newsJsonArray.getJSONObject(i)
                    val news = News(
                        newsJsonObject.getString("title"),
                        newsJsonObject.getString("author"),
                        newsJsonObject.getString("url"),
                        newsJsonObject.getString("urlToImage")
                    )
                    newsArray.add(news)
                }
                mAdaptor.updateNews(newsArray)
            },
            {

            }
        )
      MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)

    }

    override fun itemClick(items: News) {
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(this, Uri.parse(items.url))
    }

}

