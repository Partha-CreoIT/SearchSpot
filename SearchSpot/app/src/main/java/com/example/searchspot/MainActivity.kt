package com.example.searchspot

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CitiesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)


        val client = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()


        val gson = GsonBuilder().setLenient().create()


        val retrofit = Retrofit.Builder()
            .baseUrl("https://dev.urbanaut.in/api/v1.4/city/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()


        val service = retrofit.create(ApiService::class.java)


        CoroutineScope(Dispatchers.IO).launch {
            val cities = service.getCities()
            cities.enqueue(object : Callback<List<City>> {
                override fun onResponse(call: Call<List<City>>, response: Response<List<City>>) {
                    if (response.isSuccessful) {
                        val cityList = response.body()
                        if (cityList != null) {
                            adapter = CitiesAdapter(cityList)
                            recyclerView.adapter = adapter
                        }
                    } else {
                        Log.d("MainActivity", "Response not successful")
                    }
                }

                override fun onFailure(call: Call<List<City>>, t: Throwable) {
                    Log.d("MainActivity", "onFailure: ${t.message}")
                }
            })
        }

    }
}
//class MainActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        CoroutineScope(Dispatchers.IO).launch {
//            val apiService = RetrofitClient.createService(ApiService::class.java)
//            val call = apiService.getCities()
//            call?.enqueue(object : Callback<List<City>> {
//                override fun onResponse(call: Call<List<City>>, response: Response<List<City>>) {
//                    if (response.isSuccessful) {
//                        // Handle successful response
//                        val cities = response.body()
//                        // Do something with the cities list
//                    } else {
//                        // Handle error
//                        Log.e("API", "Error: ${response.code()}")
//                    }
//                }
//
//                override fun onFailure(call: Call<List<City>>, t: Throwable) {
//                    // Handle error
//                    Log.e("API", "Error: ${t.message}")
//                }
//            })
//        }
//    }
//}