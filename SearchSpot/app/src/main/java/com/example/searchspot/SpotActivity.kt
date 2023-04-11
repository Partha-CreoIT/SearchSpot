package com.example.searchspot

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.searchspot.databinding.ActivitySpotBinding

class SpotActivity : AppCompatActivity() {
    private lateinit var spotRecyclerView: RecyclerView
//    private lateinit var adapter: SpotAdapter

    private val TAG = "SpotyActivity"
    private lateinit var binding: ActivitySpotBinding
    lateinit var viewModel: SpotViewModel
    private val retrofitService1 = ApiInterface1.getInstance()
    val adapter = SpotAdapter1()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spot)
        spotRecyclerView = findViewById(R.id.spotRecyclerView)
        spotRecyclerView.layoutManager = LinearLayoutManager(this)

        binding = ActivitySpotBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(
            this,
            MySpotModel(SpotRepo(retrofitService1))
        ).get(SpotViewModel::class.java)
        binding.spotRecyclerView.adapter = adapter

        viewModel.spotList.observe(this) {
            Log.d(TAG, "onCreate: $it")
            adapter.selectSpotList()
            adapter.also { spotRecyclerView.adapter = it }
        }
        viewModel.errorMessage.observe(this, Observer {
        })
        viewModel.getAllSpots()







/*
        var dividerItemDecoration = DividerItemDecoration(this, RecyclerView.VERTICAL)
        ResourcesCompat.getDrawable(resources, R.drawable.divider, null)?.let {
            dividerItemDecoration.setDrawable(it)
        }
        spotRecyclerView.addItemDecoration(dividerItemDecoration)
        spotRecyclerView.layoutManager = LinearLayoutManager(this)*/























        /*val service = RetrofitClient1.createService(ApiService::class.java)


        intent.getStringExtra("cityName")?.let {
            supportActionBar?.title = "Spots In $it"
            service.getSpots(it).enqueue(object : Callback<Spot> {
                override fun onResponse(call: Call<Spot>, response: Response<Spot>) {

                    if (response.isSuccessful) {
                        val spotList = response.body()
                        if (spotList != null) {
                            adapter = SpotAdapter(spotList.results)
                            adapter.also { spotRecyclerView.adapter = it }
                        }
                    } else {
                        Log.d("SpotActivity", "Response not successful")
                    }
                }


                override fun onFailure(call: Call<Spot>, t: Throwable) {
                    Log.d("SpotActivity", "onFailure: ${t.message}")
                }

            })
        }*/


    }
}
