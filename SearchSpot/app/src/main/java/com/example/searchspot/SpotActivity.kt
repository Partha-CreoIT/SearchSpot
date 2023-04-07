package com.example.searchspot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SpotActivity : AppCompatActivity() {
    private lateinit var spotRecyclerView: RecyclerView
    private lateinit var adapter: SpotAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spot)

        spotRecyclerView = findViewById(R.id.spotRecyclerView)
        spotRecyclerView.layoutManager = LinearLayoutManager(this)




        val service = RetrofitClient1.createService(ApiService::class.java)

        service.getSpot().enqueue(object : Callback<Spot> {
            override fun onResponse(call: Call<Spot>, response: Response<Spot>) {

                if (response.isSuccessful) {
                    val spotList = response.body()
                    if (spotList != null) {
                        adapter = SpotAdapter(spotList.results)
                        adapter.also { spotRecyclerView.adapter = it }
                    }
                } else {
                    Log.d("MainActivity", "Response not successful")
                }
            }

            override fun onFailure(call: Call<Spot>, t: Throwable) {
                Log.d("MainActivity", "onFailure: ${t.message}")
            }

        })
    }
}