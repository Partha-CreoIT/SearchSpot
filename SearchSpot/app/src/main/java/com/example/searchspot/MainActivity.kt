package com.example.searchspot

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CitiesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)


//        val client = OkHttpClient.Builder()
//            .connectTimeout(30, TimeUnit.SECONDS)
//            .readTimeout(30, TimeUnit.SECONDS)
//            .writeTimeout(30, TimeUnit.SECONDS)
//            .build()
//
//
//        val gson = GsonBuilder().setLenient().create()


//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://dev.urbanaut.in/api/v1.4/city/?format=json")
//            .client(client)
//            .addConverterFactory(GsonConverterFactory.create(gson))
//            .build()


        val service = RetrofitClient.createService(ApiService::class.java)

        service.getCities().enqueue(object : Callback<CityResponse> {
            override fun onResponse(call: Call<CityResponse>, response: Response<CityResponse>) {

                if (response.isSuccessful) {
                    val cityList = response.body()
                    if (cityList != null) {
                        adapter = CitiesAdapter(cityList.results)
                        adapter.also { recyclerView.adapter = it }
                    }
                } else {
                    Log.d("MainActivity", "Response not successful")
                }
            }

            override fun onFailure(call: Call<CityResponse>, t: Throwable) {
                Log.d("MainActivity", "onFailure: ${t.message}")
            }

        })
    }

}

