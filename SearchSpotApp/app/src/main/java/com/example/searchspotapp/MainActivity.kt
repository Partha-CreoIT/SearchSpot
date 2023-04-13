package com.example.searchspotapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.searchspotapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private val TAG = "MainActivity"
    private lateinit var binding : ActivityMainBinding
    lateinit var viewModel:CityViewModel
    private val retrofitService = RetrofitService.getInstance()
    val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, MyViewModel(CityRepository(retrofitService))).get(CityViewModel::class.java)
        binding.recyclerView.adapter = adapter
        viewModel.cityList.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.also { recyclerView.adapter = it }
        })
        viewModel.errorMessage.observe(this, Observer {
        })
        viewModel.getAllCity()
    }
}
