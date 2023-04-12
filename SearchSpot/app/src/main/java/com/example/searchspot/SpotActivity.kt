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


        var dividerItemDecoration = DividerItemDecoration(this, RecyclerView.VERTICAL)
        ResourcesCompat.getDrawable(resources, R.drawable.divider, null)?.let {
            dividerItemDecoration.setDrawable(it)
        }
        spotRecyclerView.addItemDecoration(dividerItemDecoration)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
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
        if (city != null) {
            supportActionBar?.title = "Spots In $city"
            viewModel.getAllSpots(city)
        }


    }
}
