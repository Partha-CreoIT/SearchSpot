package com.example.searchspot

import MainAdapter
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.searchspot.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

//    lateinit var adapter1: CitiesAdapter
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: CityViewModel
    private val retrofitService = ApiInterface.getInstance()
    val adapter = MainAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setTitle("Select The City")


        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(
            this,
            MyViewModel(CityRepo(retrofitService))
        ).get(CityViewModel::class.java)
        binding.recyclerView.adapter = adapter

        viewModel.cityList.observe(this) {
            Log.d(TAG, "onCreate: $it")
            adapter.setCityList(it)
            adapter.also { recyclerView.adapter = it }
        }
        viewModel.errorMessage.observe(this, Observer {
        })
        viewModel.getAllCity()


        /*val service = RetrofitClient.createService(ApiService::class.java)

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

        })*/
    }

}

