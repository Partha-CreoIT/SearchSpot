package com.example.searchspot

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.searchspot.databinding.ActivitySpotBinding

class SpotActivity : AppCompatActivity() {

    private val TAG = "SpotActivity"
    private lateinit var binding: ActivitySpotBinding
    lateinit var viewModel: SpotViewModel
    private val retrofitService1 = ApiInterface1.getInstance()
    private val adapter = SpotAdapter1()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spot)
        val spotRecyclerView = findViewById<RecyclerView>(R.id.spotRecyclerView)
        spotRecyclerView.adapter = adapter
        spotRecyclerView.layoutManager = LinearLayoutManager(this)
        binding = ActivitySpotBinding.inflate(layoutInflater)
        setContentView(binding.root)




        viewModel = ViewModelProvider(
            this,
            MySpotModel(SpotRepo(retrofitService1))
        ).get(SpotViewModel::class.java)
        binding.spotRecyclerView.adapter = adapter
        val city = intent.getStringExtra("cityName")


        viewModel.spotList.observe(this) {
            Log.d(TAG, "onCreate: $it")
            adapter.selectSpotList(it)
            adapter.also { spotRecyclerView.adapter = it }
        }

        viewModel.errorMessage.observe(this, Observer {
        })
        binding.appBar1.back.setOnClickListener {
            val intent =  Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        if (city != null) {
            binding.appBar1.title.text = "Spots In $city"
            viewModel.getAllSpots(city)
        }



    }
}
